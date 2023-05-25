package com.sopt.instagram.domain.repository

import com.sopt.instagram.domain.entity.FriendStories

interface GetFriendStoriesRepository {
    suspend fun getFriendStories(): Result<List<FriendStories>?>
}
