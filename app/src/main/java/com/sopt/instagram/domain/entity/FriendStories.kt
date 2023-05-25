package com.sopt.instagram.domain.entity

data class FriendStories(
    val isSpecial: Boolean,
    val memberId: Int,
    val memberImageUrl: String,
    val memberName: String,
)
