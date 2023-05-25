package com.sopt.instagram.domain.repository

import com.sopt.instagram.domain.entity.FriendStory

interface GetFriendStoriesRepository {
    suspend fun getFriendStories(): Result<List<FriendStory>?>
}
