package com.sopt.instagram.data.repository

import com.sopt.instagram.data.model.request.ExampleRequestDto
import com.sopt.instagram.data.source.ExampleDataSource
import com.sopt.instagram.domain.entity.ExampleEntity
import com.sopt.instagram.domain.repository.ExampleRepository
import javax.inject.Inject

// data repository : UI와 데이터 소스 간의 상호작용 구현 (domain repository 구현체)
class ExampleRepositoryImpl @Inject constructor(
    private val exampleDataSource: ExampleDataSource,
) : ExampleRepository {
    override suspend fun postExample(exampleRequestDto: ExampleRequestDto): Result<ExampleEntity?> =
        runCatching {
            exampleDataSource.postExample(exampleRequestDto).data?.toExampleEntity()
        }
}
