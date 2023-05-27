package com.sopt.instagram.ui.story.tag

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.instagram.R
import com.sopt.instagram.databinding.FragmentTagDialogBinding
import com.sopt.instagram.util.binding.BindingBottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TagDialogFragment :
    BindingBottomSheetDialog<FragmentTagDialogBinding>(R.layout.fragment_tag_dialog) {
    private val viewModel by viewModels<TagViewModel>()
    private var tagAdapter: TagAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTagAdapter()
        getTaggedMember()
        setupTagList()
    }

    private fun initTagAdapter() {
        tagAdapter = TagAdapter()
        binding.rvTag.adapter = tagAdapter
    }

    private fun getTaggedMember() {
        arguments ?: return
        viewModel.getTagList(arguments?.getInt(KEY_STORY_INDEX) ?: 0)
    }

    private fun setupTagList() {
        viewModel.tagList.observe(viewLifecycleOwner) { tagList ->
            if (tagList.isEmpty()) {
                binding.tvTagNullDescription.visibility = View.VISIBLE
                return@observe
            }
            tagAdapter?.submitList(tagList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tagAdapter = null
    }

    companion object {
        private const val KEY_STORY_INDEX = "KeyStoryIndex"

        @JvmStatic
        fun newInstance(storyIndex: Int) = TagDialogFragment().apply {
            val args = Bundle()
            args.putInt(KEY_STORY_INDEX, storyIndex)
            arguments = args
        }
    }
}
