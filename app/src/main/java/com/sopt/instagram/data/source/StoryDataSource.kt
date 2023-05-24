package com.sopt.instagram.data.source

import com.sopt.instagram.data.model.response.GetMemberStoryResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import com.sopt.instagram.data.service.StoryService
import javax.inject.Inject

class StoryDataSource @Inject constructor(
    private val storyService: StoryService,
) {
    suspend fun getMemberStory(memberId: Int): BaseResponse<List<GetMemberStoryResponseDto>> =
        storyService.getMemberStory(memberId)
}
