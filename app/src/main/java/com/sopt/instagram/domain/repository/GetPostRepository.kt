package com.sopt.instagram.domain.repository

import com.sopt.instagram.domain.entity.Post

interface GetPostRepository {
    suspend fun getPostList(): Result<List<Post>?>
}
