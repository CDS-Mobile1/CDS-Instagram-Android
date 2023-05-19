package com.sopt.instagram.ui.story

import android.os.Bundle
import com.sopt.instagram.R
import com.sopt.instagram.databinding.ActivityStoryBinding
import com.sopt.instagram.util.binding.BindingActivity

class StoryActivity : BindingActivity<ActivityStoryBinding>(R.layout.activity_story) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
    }
}
