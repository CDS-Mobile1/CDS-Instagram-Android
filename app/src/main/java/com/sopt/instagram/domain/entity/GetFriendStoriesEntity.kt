package com.sopt.instagram.domain.entity

data class GetFriendStoriesEntity(
    val isSpecial: Boolean,
    val memberId: Int,
    val memberImageUrl: String,
    val memberName: String,
)
