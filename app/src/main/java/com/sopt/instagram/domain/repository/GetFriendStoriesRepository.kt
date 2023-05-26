package com.sopt.instagram.domain.repository

import com.sopt.instagram.domain.entity.StoryProfile

interface GetFriendStoriesRepository {
    suspend fun getFriendStories(): Result<List<StoryProfile>?>
}
