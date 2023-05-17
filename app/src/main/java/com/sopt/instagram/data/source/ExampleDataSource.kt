package com.sopt.instagram.data.source

import com.sopt.instagram.data.model.request.ExampleRequestDto
import com.sopt.instagram.data.model.response.ExampleResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import com.sopt.instagram.data.service.ExampleService
import javax.inject.Inject

// Data DataSource : 데이터베이스로부터 데이터를 가져오는 로직 포함
class ExampleDataSource @Inject constructor(
    private val exampleService: ExampleService,
) {
    suspend fun postExample(exampleRequestDto: ExampleRequestDto): BaseResponse<ExampleResponseDto> =
        exampleService.postExample(exampleRequestDto)
}
