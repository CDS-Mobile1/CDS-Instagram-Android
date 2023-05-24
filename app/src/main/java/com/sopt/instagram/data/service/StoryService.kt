package com.sopt.instagram.data.service

import com.sopt.instagram.data.model.response.GetMemberStoryResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface StoryService {
    @GET("api/story/{memberId}")
    suspend fun getMemberStory(
        @Path("memberId") memberId: Int,
    ): BaseResponse<List<GetMemberStoryResponseDto>>
}
