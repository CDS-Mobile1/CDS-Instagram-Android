package com.sopt.instagram.domain.entity

data class FriendStory(
    val isSpecial: Boolean,
    val memberId: Int,
    val memberImageUrl: String,
    val memberName: String,
)
