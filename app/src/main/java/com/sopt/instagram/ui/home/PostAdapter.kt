package com.sopt.instagram.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sopt.instagram.databinding.ItemPostBinding
import com.sopt.instagram.domain.entity.GetPostEntity
import com.sopt.instagram.util.DiffCallback

class PostAdapter : ListAdapter<GetPostEntity, PostAdapter.PostViewHolder>(diffUtil) {
    class PostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(post: GetPostEntity) {
            with(binding) {
                data = post
                ivHomeUserProfileImage.load(post.memberImageUrl)
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
        private val diffUtil = DiffCallback<GetPostEntity>(
            onItemsTheSame = { old, new -> old.memberId == new.memberId },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
