package com.sopt.instagram.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.instagram.R
import com.sopt.instagram.databinding.FragmentHomeBinding
import com.sopt.instagram.util.UiState.Error
import com.sopt.instagram.util.UiState.Failure
import com.sopt.instagram.util.UiState.Success
import com.sopt.instagram.util.binding.BindingFragment
import com.sopt.instagram.util.extension.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel by viewModels<HomeViewModel>()

    private var storyProfileAdapter: StoryProfileAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        setupGetFriendListState()
    }

    private fun initAdapter() {
        storyProfileAdapter = StoryProfileAdapter()

        viewModel.getPostListState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is Success -> {
                    binding.rvHomePost.adapter = PostAdapter().apply {
                        submitList(viewModel.postList.value)
                    }
                }

                is Failure -> {
                    requireContext().showToast("fail")
                }

                is Error -> {
                    requireContext().showToast("error")
                }
            }
        }
    }

    private fun setupGetFriendListState() {
        viewModel.getFriendStoriesListState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is Success -> {
                    binding.rvHomeStory.adapter = StoryProfileAdapter().apply {
                        submitList(viewModel.storyProfileList.value)
                    }
                }

                is Failure -> {}
                is Error -> {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        storyProfileAdapter = null
    }
}
