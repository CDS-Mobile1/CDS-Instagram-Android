package com.sopt.instagram.data.service

import com.sopt.instagram.data.model.request.ExampleRequestDto
import com.sopt.instagram.data.model.response.ExampleResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ExampleService {
    @POST("example/api")
    suspend fun postExample(
        @Body request: ExampleRequestDto,
    ): BaseResponse<ExampleResponseDto>
}
