package com.sopt.instagram.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetPostResponseDto(
    @SerialName("content")
    val content: String,
    @SerialName("imageUrlList")
    val imageUrlList: List<String>,
    @SerialName("userInfo")
    val userInfo: UserInfo,
) {
    @Serializable
    data class UserInfo(
        @SerialName("memberId")
        val memberId: Int,
        @SerialName("memberImageUrl")
        val memberImageUrl: String,
        @SerialName("memberName")
        val memberName: String,
    )
}
