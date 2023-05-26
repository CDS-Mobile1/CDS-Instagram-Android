package com.sopt.instagram.data.service

import com.sopt.instagram.data.model.response.DmListResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DmlistService {
    @Headers("Authorization:1")
    @GET("api/message")
    fun getLists(): Call<BaseResponse<List<DmListResponseDto>>>
}
