package com.sopt.instagram.ui.dm

import GetStoryAdapter
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.sopt.instagram.R
import com.sopt.instagram.data.ServicePool
import com.sopt.instagram.data.model.response.DmListResponseDto
import com.sopt.instagram.data.model.response.DmstoryResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import com.sopt.instagram.databinding.ActivityDmBinding
import com.sopt.instagram.ui.main.MainActivity
import com.sopt.instagram.util.binding.BindingActivity
import com.sopt.instagram.util.extension.showSnackbar
import com.sopt.instagram.util.extension.showToast
import retrofit2.Call
import retrofit2.Response

class DmActivity : BindingActivity<ActivityDmBinding>(R.layout.activity_dm) {

    private val dmstoryService = ServicePool.dmstoryService
    private val dmlistService = ServicePool.dmlistService
    private val dmstarredService = ServicePool.dmstarService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initStarstory()
        initList()
        binding.btnDmBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initStarstory() {
        dmstoryService.getStories()
            .enqueue(object : retrofit2.Callback<BaseResponse<List<DmstoryResponseDto>>> {

                override fun onResponse(
                    call: Call<BaseResponse<List<DmstoryResponseDto>>>,
                    response: Response<BaseResponse<List<DmstoryResponseDto>>>,
                ) {
                    binding.rvDmStarred.adapter = GetStoryAdapter()
                        .apply {
                            submitList(response.body()?.data)
                        }
                }

                override fun onFailure(
                    call: Call<BaseResponse<List<DmstoryResponseDto>>>,
                    t: Throwable,
                ) {
                    showToast("서버 통신 실패")
                }
            })
    }

    private fun initList() {
        dmlistService.getLists()
            .enqueue(object : retrofit2.Callback<BaseResponse<List<DmListResponseDto>>> {
                override fun onResponse(
                    call: Call<BaseResponse<List<DmListResponseDto>>>,
                    response: Response<BaseResponse<List<DmListResponseDto>>>,

                ) {
                    binding.rvDmMessage.adapter = GetLIstAdapter()
                        .apply {
                            submitList(response.body()?.data)
                        }
                }

                override fun onFailure(
                    call: Call<BaseResponse<List<DmListResponseDto>>>,
                    t: Throwable,
                ) {
                    showToast("서버 통신 실패")
                }
            })
    }
}
