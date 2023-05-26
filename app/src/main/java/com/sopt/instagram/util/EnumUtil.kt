package com.sopt.instagram.util

import com.sopt.instagram.domain.entity.type.StoryState

fun getStoryState(hasStory: Boolean, isSpecial: Boolean): StoryState {
    if (!hasStory) return StoryState.NONE
    if (isSpecial) return StoryState.SPECIAL
    return StoryState.DEFAULT
}
