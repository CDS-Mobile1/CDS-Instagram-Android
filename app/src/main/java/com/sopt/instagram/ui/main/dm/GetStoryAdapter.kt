package com.sopt.instagram.ui.main.dm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.instagram.databinding.ItemDmStarredBinding
import com.sopt.instagram.domain.entity.DmStory
import com.sopt.instagram.util.DiffCallback


class GetStoryAdapter :
    androidx.recyclerview.widget.ListAdapter<DmStory, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DmStoryViewHolder(
            ItemDmStarredBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DmStoryViewHolder) holder.onBind(getItem(position))
    }

    class DmStoryViewHolder(private val binding: ItemDmStarredBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(story: DmStory) {
            with(binding) {
                data = story
                Glide.with(root)
                    .load(story.memberImageUrl)
                    .into(ibDmStarredProfile)

            }
        }
    }

    companion object {
        private val diffUtil = DiffCallback<DmStory>(
            onItemsTheSame = { old, new -> old.memberId == new.memberId },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
