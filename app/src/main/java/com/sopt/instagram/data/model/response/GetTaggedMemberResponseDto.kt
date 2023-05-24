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
    // TODO: memberIntroduction 추가
//    @SerialName("memberIntroduction")
//    val memberIntroduction: String,
) {
    fun toTag() = Tag(
        id = memberId,
        profileImage = memberImageUrl,
        name = memberName,
        introduction = "소개글을 연결해주세요.",
    )
}
