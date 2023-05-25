package com.sopt.instagram.data.service
import com.sopt.instagram.data.model.response.DmstoryResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DmstoryService {
    @Headers("Authorization:1")
    @GET("api/friend/favorites/stories")
    fun getStories(): Call<BaseResponse<List<DmstoryResponseDto>>>
}
