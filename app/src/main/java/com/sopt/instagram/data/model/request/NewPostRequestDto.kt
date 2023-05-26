package com.sopt.instagram.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewPostRequestDto(
    @SerialName("content")
    val content: String,
    @SerialName("imageUrlList")
    val imageUrlList: List<String>,
)
