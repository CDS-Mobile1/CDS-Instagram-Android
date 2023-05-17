package com.sopt.instagram.domain.repository

import com.sopt.instagram.data.model.request.ExampleRequestDto
import com.sopt.instagram.domain.entity.ExampleEntity

// domain repository : UI와 데이터 소스의 상호작용에 대해 인터페이스 제공
interface ExampleRepository {
    suspend fun postExample(exampleRequestDto: ExampleRequestDto): Result<ExampleEntity?>
}
