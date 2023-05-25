package com.sopt.instagram.ui.story.member

sealed class MemberStoryUiState {
    object NextStory : MemberStoryUiState()
    object PreviousStory : MemberStoryUiState()
    object NextMember : MemberStoryUiState()
    object PreviousMember : MemberStoryUiState()
}
