package com.sopt.instagram.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.instagram.R
import com.sopt.instagram.databinding.FragmentHomeBinding
import com.sopt.instagram.util.binding.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun initAdapter() {
        binding.rvHomePost.adapter = PostAdapter().apply {
            submitList(viewModel.mockPostList)
        }
    }
}
