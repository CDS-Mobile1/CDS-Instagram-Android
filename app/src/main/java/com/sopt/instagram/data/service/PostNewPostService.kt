package com.sopt.instagram.data.service

import com.sopt.instagram.data.model.request.NewPostRequestDto
import com.sopt.instagram.data.model.response.NewPostResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface PostNewPostService {
    @POST("api/post")
    suspend fun postNewPost(
        @Body newPostRequestDto: NewPostRequestDto,
    ): NewPostResponseDto
}
