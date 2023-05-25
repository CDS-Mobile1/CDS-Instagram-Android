package com.sopt.instagram.data.model.response

import com.sopt.instagram.domain.entity.Story
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetMemberStoryResponseDto(
    @SerialName("storyId")
    val storyId: Int,
    @SerialName("storyImageUrl")
    val storyImageUrl: String,
    @SerialName("pastTime")
    val pastTime: String,
) {
    fun toStory() = Story(
        id = storyId,
        image = storyImageUrl,
        time = pastTime,
    )
}
