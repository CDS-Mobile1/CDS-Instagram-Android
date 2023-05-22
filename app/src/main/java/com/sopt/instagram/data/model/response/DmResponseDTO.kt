package com.sopt.instagram.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DmResponseDTO(
    @SerialName("memberId")
    val memberId: Int,
    @SerialName("memberImageUrl")
    val memberImageUrl: String,
    @SerialName("memberName")
    val memberName: String,
    @SerialName("isSpecial")
    val isSpecial: Boolean,

)