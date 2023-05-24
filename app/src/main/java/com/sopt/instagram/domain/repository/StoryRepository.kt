package com.sopt.instagram.domain.repository

import com.sopt.instagram.domain.entity.Story

interface StoryRepository {
    suspend fun getMemberStory(memberId: Int): Result<List<Story>?>
}
