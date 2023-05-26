package com.sopt.instagram.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.instagram.databinding.ItemHomeRecommendFriendImageBinding
import com.sopt.instagram.util.DiffCallback

class PostRecommendFriendAdapter :
    ListAdapter<Int, PostRecommendFriendAdapter.PostRecommendFriendViewHolder>(
        diffUtil,
    ) {
    class PostRecommendFriendViewHolder(private val binding: ItemHomeRecommendFriendImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(image: Int) {
            binding.ivHomeRecommendFriend.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PostRecommendFriendViewHolder {
        return PostRecommendFriendViewHolder(
            ItemHomeRecommendFriendImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: PostRecommendFriendViewHolder, position: Int) {
        return holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = DiffCallback<Int>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
