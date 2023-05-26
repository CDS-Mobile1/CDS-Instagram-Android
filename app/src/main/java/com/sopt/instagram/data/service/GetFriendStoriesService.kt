package com.sopt.instagram.data.service

import com.sopt.instagram.data.model.response.GetFriendStoriesDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import retrofit2.http.GET

interface GetFriendStoriesService {
    @GET("api/friend/stories")
    suspend fun getFriendStoriesList(): BaseResponse<List<GetFriendStoriesDto>>
}
