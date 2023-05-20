package com.sopt.instagram.ui.story

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.instagram.R
import com.sopt.instagram.databinding.FragmentStoryBinding
import com.sopt.instagram.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoryFragment : BindingFragment<FragmentStoryBinding>(R.layout.fragment_story) {
    private val viewModel by viewModels<StoryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        initStatusBarColor()
    }

    private fun initStatusBarColor() {
        with(requireActivity()) {
            window.statusBarColor = resources.getColor(R.color.black)
            // TODO: use WindowInsetsController instead of systemUiVisibility
            window.decorView.systemUiVisibility = 0
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = StoryFragment()
    }
}
