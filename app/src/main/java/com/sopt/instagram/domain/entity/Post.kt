package com.sopt.instagram.domain.entity

data class Post(
    val memberId: Int,
    val memberImageUrl: String,
    val memberName: String,
    val isSpecial: Boolean,
    val storyExists: Boolean,
    val content: String? = null,
    val imageUrlList: List<String>,
)
