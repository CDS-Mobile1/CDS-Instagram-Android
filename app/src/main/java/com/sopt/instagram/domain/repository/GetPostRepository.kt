package com.sopt.instagram.domain.repository

import com.sopt.instagram.domain.entity.GetPostEntity

interface GetPostRepository {
    suspend fun getPostList(): Result<List<GetPostEntity>?>
}
