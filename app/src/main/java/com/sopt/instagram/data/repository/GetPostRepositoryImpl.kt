package com.sopt.instagram.data.repository

import com.sopt.instagram.data.source.GetPostDataSource
import com.sopt.instagram.domain.entity.Post
import com.sopt.instagram.domain.repository.GetPostRepository
import javax.inject.Inject

class GetPostRepositoryImpl @Inject constructor(
    private val getPostDataSource: GetPostDataSource,
) : GetPostRepository {
    override suspend fun getPostList(): Result<List<Post>?> =
        runCatching {
            getPostDataSource.getPostList().data?.map { response ->
                response.toGetPostEntity()
            }
        }
}
