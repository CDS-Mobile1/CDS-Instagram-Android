package com.sopt.instagram.domain.entity

import com.sopt.instagram.domain.entity.type.StoryState

data class Post(
    val memberId: Int,
    val memberImageUrl: String,
    val memberName: String,
    val content: String? = null,
    val imageUrlList: List<String>,
    var storyState: StoryState,
)
