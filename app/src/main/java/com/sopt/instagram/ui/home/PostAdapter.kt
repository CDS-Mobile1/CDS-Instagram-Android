package com.sopt.instagram.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.instagram.data.model.response.GetPostResponseDto
import com.sopt.instagram.databinding.ItemPostBinding
import com.sopt.instagram.util.DiffCallback

class PostAdapter : ListAdapter<GetPostResponseDto, PostAdapter.PostViewHolder>(diffUtil) {
    class PostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(post: GetPostResponseDto) {
            with(binding) {
                data = post
                Glide.with(root)
                    .load(post.userInfo.memberImageUrl)
                    .into(ivHomeUserProfileImage)
                vpHomePostImage.adapter = PostImagesAdapter().apply {
                    submitList(post.imageUrlList)
                }
                spiHomeImageIndicator.attachToPager(vpHomePostImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = DiffCallback<GetPostResponseDto>(
            onItemsTheSame = { old, new -> old.userInfo.memberId == new.userInfo.memberId },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
