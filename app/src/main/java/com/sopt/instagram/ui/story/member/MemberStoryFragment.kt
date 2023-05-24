package com.sopt.instagram.ui.story.member

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.sopt.instagram.R
import com.sopt.instagram.databinding.FragmentMemberStoryBinding
import com.sopt.instagram.ui.story.StoryViewModel
import com.sopt.instagram.ui.story.member.MemberStoryUiState.NextMember
import com.sopt.instagram.ui.story.member.MemberStoryUiState.NextStory
import com.sopt.instagram.ui.story.member.MemberStoryUiState.PreviousMember
import com.sopt.instagram.ui.story.member.MemberStoryUiState.PreviousStory
import com.sopt.instagram.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemberStoryFragment :
    BindingFragment<FragmentMemberStoryBinding>(R.layout.fragment_member_story) {
    private val activityViewModel by activityViewModels<StoryViewModel>()
    private val viewModel by viewModels<MemberStoryViewModel>()

    private var _storyIndex: Int? = null
    private val storyIndex
        get() = requireNotNull(_storyIndex)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.avm = activityViewModel
        binding.vm = viewModel

        getIndexStory()
        initStatusBarColor()
        setupStoryState()
    }

    private fun getIndexStory() {
        arguments ?: return
        _storyIndex = arguments?.getInt(KEY_INDEX_STORY)
        binding.index = _storyIndex
    }

    private fun initStatusBarColor() {
        with(requireActivity()) {
            window.statusBarColor = getColor(R.color.black)
            // TODO: use WindowInsetsController instead of systemUiVisibility
            window.decorView.systemUiVisibility = 0
        }
    }

    private fun setupStoryState() {
        viewModel.storyState.observe(viewLifecycleOwner) { state ->
            when (state) {
                NextStory -> {
                    viewModel.setCurrentStory()
                    // TODO: 프로그래스 바 증가
                }

                PreviousStory -> {
                    viewModel.setCurrentStory()
                    // TODO: 프로그래스 바 감소
                }

                NextMember -> {
                    activityViewModel.setCurrentMember(storyIndex + 1)
                }

                PreviousMember -> {
                    activityViewModel.setCurrentMember(storyIndex - 1)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _storyIndex = null
    }

    companion object {
        private const val KEY_INDEX_STORY = "KeyIndexStory"

        @JvmStatic
        fun newInstance(index: Int) = MemberStoryFragment().apply {
            val args = Bundle()
            args.putInt(KEY_INDEX_STORY, index)
            arguments = args
        }
    }
}
