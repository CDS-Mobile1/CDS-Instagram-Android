package com.sopt.instagram.domain.entity

import com.sopt.instagram.domain.entity.type.StoryState

data class StoryProfile(
    val id: Int,
    val profile: String,
    val name: String,
    val storyState: StoryState
)
