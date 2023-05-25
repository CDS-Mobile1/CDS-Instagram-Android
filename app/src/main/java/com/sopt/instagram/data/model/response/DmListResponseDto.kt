package com.sopt.instagram.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DmListResponseDto(
    @SerialName("memberId")
    val memberId: Int,
    @SerialName("memberImageUrl")
    val memberImageUrl: String,
    @SerialName("memberName")
    val memberName: String,
    @SerialName("latestMessage")
    val latestMessage: String,
    @SerialName("storyExists")
    val storyExists: Boolean,
    @SerialName("special")
    val special: Boolean,
    @SerialName("favorite")
    val favorite: Boolean,

)
