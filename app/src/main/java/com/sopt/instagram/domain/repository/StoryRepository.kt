package com.sopt.instagram.domain.repository

import com.sopt.instagram.domain.entity.Story
import com.sopt.instagram.domain.entity.Tag

interface StoryRepository {
    suspend fun getMemberStory(memberId: Int): Result<List<Story>?>

    suspend fun getTaggedMember(storyId: Int): Result<List<Tag>?>
}
