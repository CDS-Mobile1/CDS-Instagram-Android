package com.sopt.instagram.data.service

import com.sopt.instagram.data.model.request.ExampleRequestDto
import com.sopt.instagram.data.model.response.ExampleResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

// Data Service : 외부 서비스와 통신하기 위한 인터페이스(API) 포함
interface ExampleService {
    @POST("example/api")
    suspend fun postExample(
        @Body request: ExampleRequestDto,
    ): BaseResponse<ExampleResponseDto>
}
