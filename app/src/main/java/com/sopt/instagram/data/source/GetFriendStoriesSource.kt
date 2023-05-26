package com.sopt.instagram.data.source

import com.sopt.instagram.data.model.response.GetFriendStoriesDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import com.sopt.instagram.data.service.GetFriendStoriesService
import javax.inject.Inject

class GetFriendStoriesSource @Inject constructor(
    private val getFriendStoriesService: GetFriendStoriesService,
) {
    suspend fun getFriendStoriesList(): BaseResponse<List<GetFriendStoriesDto>> =
        getFriendStoriesService.getFriendStoriesList()
}
