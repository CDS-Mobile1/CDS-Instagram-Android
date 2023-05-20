package com.sopt.instagram.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.instagram.data.model.response.GetPostResponseDto
import com.sopt.instagram.databinding.ItemPostImageBinding
import com.sopt.instagram.util.DiffCallback

class PostImagesAdapter : ListAdapter<String, PostImagesAdapter.PostImagesViewHolder>(
    diffUtil) {
    class PostImagesViewHolder(private val binding: ItemPostImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(postImage: String) {
            with(binding) {
                Glide.with(root)
                    .load(postImage)
                    .into(ivPostImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostImagesViewHolder {
        return PostImagesAdapter.PostImagesViewHolder(
            ItemPostImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostImagesViewHolder, position: Int) {
        holder.onBind(getItem(position))

    }
    companion object {
        private val diffUtil = DiffCallback<String>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}