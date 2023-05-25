package com.sopt.instagram.data.service

import com.sopt.instagram.data.model.response.GetPostResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import retrofit2.http.GET

interface GetPostService {
    @GET("api/post")
    suspend fun getPostList(): BaseResponse<List<GetPostResponseDto>>
}
