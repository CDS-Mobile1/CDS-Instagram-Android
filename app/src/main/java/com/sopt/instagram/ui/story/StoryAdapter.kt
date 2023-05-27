package com.sopt.instagram.ui.story

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sopt.instagram.domain.entity.Member
import com.sopt.instagram.ui.story.member.MemberStoryFragment

class StoryAdapter(
    fragmentActivity: FragmentActivity,
    private val storyListSize: Int,
    private val memberList: List<Member>,
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = storyListSize

    override fun createFragment(position: Int): Fragment = MemberStoryFragment.newInstance(position, memberList[position].id)
}
