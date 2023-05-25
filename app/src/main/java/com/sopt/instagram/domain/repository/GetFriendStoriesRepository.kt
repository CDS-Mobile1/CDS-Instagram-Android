package com.sopt.instagram.domain.repository

import com.sopt.instagram.domain.entity.GetFriendStoriesEntity

interface GetFriendStoriesRepository {
    suspend fun getFriendStories(): Result<List<GetFriendStoriesEntity>?>
}
