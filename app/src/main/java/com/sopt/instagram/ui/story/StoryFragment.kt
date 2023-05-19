package com.sopt.instagram.ui.story

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class StoryFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = StoryFragment()
    }
}
