package com.sopt.instagram.data.model.response

import com.sopt.instagram.domain.entity.StoryProfile
import com.sopt.instagram.util.getStoryState
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
        id = memberId,
        profile = memberImageUrl,
        name = memberName,
        storyState = getStoryState(
            hasStory = true,
            isSpecial = isSpecial,
        ),
    )
}
