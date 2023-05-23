package com.sopt.instagram.ui.story.member

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.sopt.instagram.R
import com.sopt.instagram.databinding.FragmentMemberStoryBinding
import com.sopt.instagram.ui.story.StoryViewModel
import com.sopt.instagram.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemberStoryFragment :
    BindingFragment<FragmentMemberStoryBinding>(R.layout.fragment_member_story) {
    private val activityViewModel by activityViewModels<StoryViewModel>()
    private var storyIndex: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.avm = activityViewModel

        getIndexStory()
        initStatusBarColor()
    }

    private fun getIndexStory() {
        arguments ?: return
        storyIndex = arguments?.getInt(KEY_INDEX_STORY)
        binding.index = storyIndex
    }

    private fun initStatusBarColor() {
        with(requireActivity()) {
            window.statusBarColor = getColor(R.color.black)
            // TODO: use WindowInsetsController instead of systemUiVisibility
            window.decorView.systemUiVisibility = 0
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        storyIndex = null
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
