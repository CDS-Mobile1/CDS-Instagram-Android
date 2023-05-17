package com.sopt.instagram.data.source

import com.sopt.instagram.data.model.request.ExampleRequestDto
import com.sopt.instagram.data.model.response.ExampleResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import com.sopt.instagram.data.service.ExampleService
import javax.inject.Inject

class ExampleDataSource @Inject constructor(
    private val exampleService: ExampleService,
) {
    suspend fun postExample(exampleRequestDto: ExampleRequestDto): BaseResponse<ExampleResponseDto> =
        exampleService.postExample(exampleRequestDto)
}
