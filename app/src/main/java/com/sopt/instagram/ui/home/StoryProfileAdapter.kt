package com.sopt.instagram.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.instagram.databinding.ItemStoryBinding
import com.sopt.instagram.domain.entity.StoryProfile
import com.sopt.instagram.ui.home.StoryProfileAdapter.StoryProfileViewHolder
import com.sopt.instagram.util.DiffCallback

class StoryProfileAdapter : ListAdapter<StoryProfile, StoryProfileViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryProfileViewHolder {
        return StoryProfileViewHolder(
            ItemStoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: StoryProfileViewHolder, position: Int) {
        holder.setStoryProfile(getItem(position))
    }

    class StoryProfileViewHolder(private val binding: ItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setStoryProfile(storyProfile: StoryProfile) {
            binding.data = storyProfile
        }
    }

    companion object {
        private val diffUtil = DiffCallback<StoryProfile>(
            onItemsTheSame = { old, new -> old.id == new.id },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
