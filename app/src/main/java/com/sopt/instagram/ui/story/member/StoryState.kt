package com.sopt.instagram.ui.story.member

sealed class StoryState {
    object NextStory : StoryState()
    object PreviousStory : StoryState()
    object NextMember : StoryState()
    object PreviousMember : StoryState()
}
