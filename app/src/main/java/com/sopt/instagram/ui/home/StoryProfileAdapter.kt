package com.sopt.instagram.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.instagram.R
import com.sopt.instagram.databinding.ItemStoryBinding
import com.sopt.instagram.domain.entity.Member
import com.sopt.instagram.domain.entity.StoryProfile
import com.sopt.instagram.ui.home.StoryProfileAdapter.StoryProfileViewHolder
import com.sopt.instagram.ui.story.StoryActivity
import com.sopt.instagram.ui.story.StoryActivity.Companion.EXTRA_MEMBER_INDEX
import com.sopt.instagram.ui.story.StoryActivity.Companion.EXTRA_MEMBER_LIST
import com.sopt.instagram.util.DiffCallback
import com.sopt.instagram.util.extension.setOnSingleClickListener

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
        holder.setStoryProfile(getItem(position), currentList, position)
    }

    class StoryProfileViewHolder(private val binding: ItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setStoryProfile(
            storyProfile: StoryProfile,
            profileList: List<StoryProfile>,
            memberIndex: Int,
        ) {
            with(binding) {
                data = storyProfile
                viewStoryItemStroke.setOnSingleClickListener {
                    Intent(root.context, StoryActivity::class.java).apply {
                        val memberList = profileList.map { profile ->
                            Member(
                                id = profile.id,
                                profileImage = profile.profile,
                                name = profile.name,
                            )
                        } as ArrayList<Member>
                        putExtra(EXTRA_MEMBER_LIST, memberList)
                        putExtra(EXTRA_MEMBER_INDEX, memberIndex)
                        ContextCompat.startActivity(root.context, this, null)
                    }
                    viewStoryItemStroke.background = AppCompatResources.getDrawable(
                        root.context,
                        R.drawable.bg_story_profile_read,
                    )
                }
            }
        }
    }

    companion object {
        private val diffUtil = DiffCallback<StoryProfile>(
            onItemsTheSame = { old, new -> old.id == new.id },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}
