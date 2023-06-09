package com.sopt.instagram.ui.story.member

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.sopt.instagram.R
import com.sopt.instagram.databinding.FragmentMemberStoryBinding
import com.sopt.instagram.ui.story.StoryViewModel
import com.sopt.instagram.ui.story.member.MemberStoryUiState.GetMemberStorySuccess
import com.sopt.instagram.ui.story.member.MemberStoryUiState.NextMember
import com.sopt.instagram.ui.story.member.MemberStoryUiState.NextStory
import com.sopt.instagram.ui.story.member.MemberStoryUiState.PreviousMember
import com.sopt.instagram.ui.story.member.MemberStoryUiState.PreviousStory
import com.sopt.instagram.ui.story.tag.TagDialogFragment
import com.sopt.instagram.util.binding.BindingFragment
import com.sopt.instagram.util.extension.setOnSingleClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemberStoryFragment :
    BindingFragment<FragmentMemberStoryBinding>(R.layout.fragment_member_story) {
    private val activityViewModel by activityViewModels<StoryViewModel>()
    private val viewModel by viewModels<MemberStoryViewModel>()

    private var _storyIndex: Int? = null
    private val storyIndex
        get() = requireNotNull(_storyIndex)

    private var progressBars: MutableList<View>? = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.avm = activityViewModel
        binding.vm = viewModel

        getBundleArgs()
        setupStoryState()
        initStoryTagBtnClickListener()
    }

    private fun getBundleArgs() {
        arguments ?: return
        viewModel.getStory(arguments?.getInt(ARGS_MEMBER_ID) ?: 3)
        _storyIndex = arguments?.getInt(ARGS_INDEX_STORY)
        binding.index = _storyIndex
    }

    private fun setupStoryState() {
        viewModel.storyState.observe(viewLifecycleOwner) { state ->
            when (state) {
                GetMemberStorySuccess -> setProgressBar()
                NextStory -> {
                    viewModel.setCurrentStory()
                    setProgressBarBackground(
                        viewModel.storyIndex,
                        R.drawable.shape_gray5_fill_1000_rect,
                    )
                }

                PreviousStory -> {
                    viewModel.setCurrentStory()
                    setProgressBarBackground(
                        viewModel.storyIndex + 1,
                        R.drawable.shape_gray2_fill_1000_rect,
                    )
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

    private fun setProgressBar() {
        for (i in 1..viewModel.storyList.size) {
            progressBars?.add(
                layoutInflater.inflate(
                    R.layout.view_story_progress_bar,
                    binding.layoutStoryProgressBar,
                ),
            )
        }
        setProgressBarBackground(0, R.drawable.shape_gray5_fill_1000_rect)
    }

    private fun setProgressBarBackground(childIndex: Int, backgroundDrawable: Int) {
        binding.layoutStoryProgressBar.getChildAt(childIndex).background =
            AppCompatResources.getDrawable(
                requireContext(),
                backgroundDrawable,
            )
    }

    private fun initStoryTagBtnClickListener() {
        binding.btnStoryTag.setOnSingleClickListener {
            viewModel.currentStory.value?.id?.let { id ->
                TagDialogFragment.newInstance(id).show(parentFragmentManager, TAG_DIALOG)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _storyIndex = null
        progressBars = null
    }

    companion object {
        private const val ARGS_INDEX_STORY = "IndexStory"
        private const val ARGS_MEMBER_ID = "MemberId"
        private const val TAG_DIALOG = "TagDialog"

        @JvmStatic
        fun newInstance(index: Int, memberId: Int) = MemberStoryFragment().apply {
            val args = Bundle()
            args.putInt(ARGS_INDEX_STORY, index)
            args.putInt(ARGS_MEMBER_ID, memberId)
            arguments = args
        }
    }
}
