package com.sopt.instagram.data.model.response

import com.sopt.instagram.domain.entity.Post
import com.sopt.instagram.util.getStoryState
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetPostResponseDto(
    @SerialName("content")
    val content: String? = null,
    @SerialName("imageUrlList")
    val imageUrlList: List<String>,
    @SerialName("isSpecial")
    val isSpecial: Boolean,
    @SerialName("memberId")
    val memberId: Int,
    @SerialName("memberImageUrl")
    val memberImageUrl: String,
    @SerialName("memberName")
    val memberName: String,
    @SerialName("storyExists")
    val storyExists: Boolean,
) {
    fun toGetPostEntity() = Post(
        memberId = memberId,
        memberImageUrl = memberImageUrl,
        memberName = memberName,
        content = content,
        imageUrlList = imageUrlList,
        storyState = getStoryState(storyExists, isSpecial),
    )
}
