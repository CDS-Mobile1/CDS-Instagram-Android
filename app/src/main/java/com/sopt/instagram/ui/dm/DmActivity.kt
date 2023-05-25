package com.sopt.instagram.ui.dm

import GetStoryAdapter
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.sopt.instagram.R
import com.sopt.instagram.data.ServicePool
import com.sopt.instagram.data.model.response.DmstoryResponseDto
import com.sopt.instagram.databinding.ActivityDmBinding
import com.sopt.instagram.util.binding.BindingActivity
import retrofit2.Call
import retrofit2.Response

class DmActivity : BindingActivity<ActivityDmBinding>(R.layout.activity_dm) {

    private val dmstoryService = ServicePool.dmstoryService
    private val dmstarredService = ServicePool.dmstarService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun initStory() {
        dmstoryService.getStories()
            .enqueue(object : retrofit2.Callback<List<DmstoryResponseDto>> {
                override fun onResponse(
                    call: Call<DmstoryResponseDto>,
                    response: Response<DmstoryResponseDto>,
                ) {
                    if (response.isSuccessful) {
                        Snackbar.make(
                            binding.root,
                            "디엠 스토리 조회 성공",
                            Snackbar.LENGTH_SHORT,
                        ).show()

                        binding.rvDmStarred.adapter=GetStoryAdapter()
                            .apply {
                                submitList(response.body())
                            }
                    } else {
                        // 실패한 응답
                        Snackbar.make(
                            binding.root,
                            "디엠 스토리 조회 실패",
                            Snackbar.LENGTH_SHORT,
                        ).show()
                    }
                }

                override fun onFailure(call: Call<DmstoryResponseDto>, t: Throwable) {

                    Snackbar.make(
                        binding.root,
                        "서버 통신 실패",
                        Snackbar.LENGTH_SHORT,
                    ).show()
                }
            })
    }
}


