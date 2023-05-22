package com.sopt.instagram.ui.main.dm

import GetStoryAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sopt.instagram.R
import com.sopt.instagram.data.ServicePool
import com.sopt.instagram.data.model.response.DmResponseDTO
import com.sopt.instagram.databinding.ActivityDmBinding
import com.sopt.instagram.databinding.ActivityMainBinding
import com.sopt.instagram.util.binding.BindingActivity
import retrofit2.Retrofit

class DmActivity : AppCompatActivity() {

    private val dmstoryService = ServicePool.dmstoryService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}