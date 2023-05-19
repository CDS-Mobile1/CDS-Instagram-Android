package com.sopt.instagram.data.service

import android.telecom.Call
import com.sopt.instagram.data.model.request.ExampleRequestDto
import com.sopt.instagram.data.model.response.ExampleResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface DmService {
    @GET("~/api/friend/favorites/stories")
    suspend fun getStories(
        @Body request: DmService,
    ): BaseResponse<DmService>
}
