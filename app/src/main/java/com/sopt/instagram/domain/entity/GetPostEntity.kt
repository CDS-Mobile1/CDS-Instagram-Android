package com.sopt.instagram.domain.entity

data class GetPostEntity(
    val memberId: Int,
    val memberImageUrl: String,
    val memberName: String,
    val isSpecial: Boolean,
    val storyExists: Boolean,
    val content: String,
    val imageUrlList: List<String>,
)
