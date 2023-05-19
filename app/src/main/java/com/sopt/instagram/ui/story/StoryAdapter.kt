package com.sopt.instagram.ui.story

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sopt.instagram.domain.entity.Member

class StoryAdapter(
    fragmentActivity: FragmentActivity,
    private val members: List<Member>,
) : FragmentStateAdapter(fragmentActivity) {
    private val fragmentList = createStoryFragment()

    private fun createStoryFragment(): List<StoryFragment> {
        val fragmentList: MutableList<StoryFragment> = mutableListOf()
        for (i in 1..members.size) {
            fragmentList.add(StoryFragment())
        }
        return fragmentList
    }

    override fun getItemCount() = members.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}
