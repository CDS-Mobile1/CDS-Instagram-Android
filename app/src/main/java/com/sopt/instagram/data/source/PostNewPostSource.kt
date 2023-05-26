package com.sopt.instagram.data.source

import com.sopt.instagram.data.model.request.NewPostRequestDto
import com.sopt.instagram.data.model.response.NewPostResponseDto
import com.sopt.instagram.data.service.PostNewPostService
import javax.inject.Inject

class PostNewPostSource @Inject constructor(
    private val postNewPostService: PostNewPostService,
) {
    suspend fun postNewPost(postRequestDto: NewPostRequestDto): NewPostResponseDto =
        postNewPostService.postNewPost(postRequestDto)
}
