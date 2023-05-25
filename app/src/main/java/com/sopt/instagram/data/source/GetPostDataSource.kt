package com.sopt.instagram.data.source

import com.sopt.instagram.data.model.response.GetPostResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import com.sopt.instagram.data.service.GetPostService
import javax.inject.Inject

class GetPostDataSource @Inject constructor(
    private val getPostService: GetPostService,
) {
    suspend fun getPostList(): BaseResponse<List<GetPostResponseDto>> =
        getPostService.getPostList()
}
