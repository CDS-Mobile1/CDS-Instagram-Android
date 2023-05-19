package com.sopt.instagram.ui.main.dm

import android.os.Bundle
import com.sopt.instagram.R
import com.sopt.instagram.databinding.ActivityDmBinding
import com.sopt.instagram.util.binding.BindingActivity

class DmActivity : BindingActivity<ActivityDmBinding>(R.layout.activity_dm) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDmBinding.inflate(layoutInflater)
    }
}