package com.sopt.instagram.data.model.response

import com.sopt.instagram.domain.entity.Tag
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetTaggedMemberResponseDto(
    @SerialName("memberId")
    val memberId: Int,
    @SerialName("memberImageUrl")
    val memberImageUrl: String,
    @SerialName("memberName")
    val memberName: String,
    @SerialName("memberIntroduction")
    val memberIntroduction: String,
) {
    fun toTag() = Tag(
        id = memberId,
        profileImage = memberImageUrl,
        name = memberName,
        introduction = memberIntroduction,
    )
}
