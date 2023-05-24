package com.sopt.instagram.data.repository

import com.sopt.instagram.data.source.StoryDataSource
import com.sopt.instagram.domain.entity.Story
import com.sopt.instagram.domain.repository.StoryRepository
import javax.inject.Inject

class StoryRepositoryImpl @Inject constructor(
    private val storyDataSource: StoryDataSource,
) : StoryRepository {
    override suspend fun getMemberStory(memberId: Int): Result<List<Story>?> =
        runCatching {
            storyDataSource.getMemberStory(memberId).data?.map { response ->
                response.toStory()
            }
        }
}
