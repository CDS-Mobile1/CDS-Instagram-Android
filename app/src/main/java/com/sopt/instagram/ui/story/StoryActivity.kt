package com.sopt.instagram.ui.story

import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.instagram.R
import com.sopt.instagram.databinding.ActivityStoryBinding
import com.sopt.instagram.domain.entity.Member
import com.sopt.instagram.ui.story.StoryUiState.ChangeMember
import com.sopt.instagram.ui.story.StoryUiState.Finish
import com.sopt.instagram.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoryActivity : BindingActivity<ActivityStoryBinding>(R.layout.activity_story) {
    private val viewModel by viewModels<StoryViewModel>()
    private val index by lazy { intent.getIntExtra(EXTRA_MEMBER_INDEX, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initStatusBarColor()
        getIntentData()
        initViewPager()
        setCurrentMember()
        setupStoryUiState()
    }

    private fun initStatusBarColor() {
        window.statusBarColor = getColor(com.sopt.instagram.R.color.black)
        // TODO: use WindowInsetsController instead of systemUiVisibility
        window.decorView.systemUiVisibility = 0
    }

    private fun getIntentData() {
        val memberList = intent.getSerializableExtra(EXTRA_MEMBER_LIST)
        try {
            viewModel.setMemberList(memberList as List<Member>)
        } catch (e: Exception) {
            viewModel.getDummyMember()
        }
    }

    private fun initViewPager() {
        with(binding) {
            vpStory.adapter = StoryAdapter(
                fragmentActivity = this@StoryActivity,
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

    override fun onDestroy() {
        super.onDestroy()
        window.statusBarColor = getColor(com.sopt.instagram.R.color.white)
        // TODO: use WindowInsetsController instead of systemUiVisibility
        window.decorView.systemUiVisibility = android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    companion object {
        const val EXTRA_MEMBER_LIST = "MemberList"
        const val EXTRA_MEMBER_INDEX = "MemberIndex"
    }
}
