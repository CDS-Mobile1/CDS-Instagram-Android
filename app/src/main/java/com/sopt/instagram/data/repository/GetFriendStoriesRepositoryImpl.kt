package com.sopt.instagram.data.repository

import com.sopt.instagram.data.source.GetFriendStoriesSource
import com.sopt.instagram.domain.entity.StoryProfile
import com.sopt.instagram.domain.repository.GetFriendStoriesRepository
import javax.inject.Inject

class GetFriendStoriesRepositoryImpl @Inject constructor(
    private val getFriendStoriesSource: GetFriendStoriesSource,
) : GetFriendStoriesRepository {
    override suspend fun getFriendStories(): Result<List<StoryProfile>?> =
        runCatching {
            getFriendStoriesSource.getFriendStoriesList().data?.map { response ->
                response.toGetFriendStoriesEntity()
            }
        }
}
