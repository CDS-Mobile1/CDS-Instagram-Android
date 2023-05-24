package com.sopt.instagram.ui.main.dm

import android.os.Bundle
import com.sopt.instagram.R
import com.sopt.instagram.data.ServicePool
import com.sopt.instagram.databinding.ActivityDmBinding
import com.sopt.instagram.util.binding.BindingActivity

class DmActivity : BindingActivity<ActivityDmBinding>(R.layout.activity_dm) {

    private val dmstoryService = ServicePool.dmstoryService
    private val dmstarredService = ServicePool.dmstarService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
