package com.sopt.instagram.data.model.response

import com.sopt.instagram.domain.entity.NewPost
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewPostResponseDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("success")
    val success: Boolean,
) {
    fun toNewPost() = NewPost(
        code = code,
        message = message,
        success = success,
    )
}
