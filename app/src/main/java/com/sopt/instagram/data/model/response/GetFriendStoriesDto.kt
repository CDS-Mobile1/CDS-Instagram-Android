package com.sopt.instagram.data.model.response

import com.sopt.instagram.domain.entity.StoryProfile
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetFriendStoriesDto(
    @SerialName("isSpecial")
    val isSpecial: Boolean,
    @SerialName("memberId")
    val memberId: Int,
    @SerialName("memberImageUrl")
    val memberImageUrl: String,
    @SerialName("memberName")
    val memberName: String,
) {
    fun toGetFriendStoriesEntity() = StoryProfile(
        isSpecial = isSpecial,
        memberId = memberId,
        memberImageUrl = memberImageUrl,
        memberName = memberName,
    )
}
