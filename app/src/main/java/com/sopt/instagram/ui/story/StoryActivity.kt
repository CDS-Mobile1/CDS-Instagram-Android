package com.sopt.instagram.ui.story

import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.instagram.R
import com.sopt.instagram.databinding.ActivityStoryBinding
import com.sopt.instagram.ui.story.StoryUiState.ChangeMember
import com.sopt.instagram.ui.story.StoryUiState.Finish
import com.sopt.instagram.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoryActivity : BindingActivity<ActivityStoryBinding>(R.layout.activity_story) {
    private val viewModel by viewModels<StoryViewModel>()
    private var index = 1 // TODO: Main Activity에서 id 넘겨 받아 by lazy로 처리하기

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewPager()
        setCurrentMember()
        setupStoryUiState()
    }

    private fun initViewPager() {
        with(binding) {
            vpStory.adapter = StoryAdapter(
                fragmentActivity = this@StoryActivity,
                // TODO: 한 명의 스토리만 보여주는 경우 처리
                storyListSize = viewModel.memberList.size,
            )
            vpStory.setPageTransformer(CubeOutRotationTransformer())
            vpStory.isUserInputEnabled = false
        }
    }

    private fun setCurrentMember() {
        viewModel.setCurrentMember(index)
        binding.vpStory.currentItem = index
    }

    private fun setupStoryUiState() {
        viewModel.storyState.observe(this) { state ->
            when (state) {
                is ChangeMember -> {
                    binding.vpStory.currentItem = state.index
                }
                is Finish -> finish()
            }
        }
    }
}
