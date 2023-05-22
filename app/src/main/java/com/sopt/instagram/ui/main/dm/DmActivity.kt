package com.sopt.instagram.ui.main.dm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sopt.instagram.R
import com.sopt.instagram.data.ServicePool
import com.sopt.instagram.databinding.ActivityDmBinding
import com.sopt.instagram.util.binding.BindingActivity

class DmActivity :  BindingActivity<ActivityDmBinding>(R.layout.activity_dm) {

    private val dmstoryService = ServicePool.dmstoryService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}