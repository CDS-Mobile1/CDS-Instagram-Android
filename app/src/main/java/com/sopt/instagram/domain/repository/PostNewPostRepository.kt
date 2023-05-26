package com.sopt.instagram.domain.repository

import com.sopt.instagram.data.model.request.NewPostRequestDto
import com.sopt.instagram.domain.entity.NewPost

interface PostNewPostRepository {
    suspend fun postNewPost(newPostRequestDto: NewPostRequestDto): Result<NewPost>
}
