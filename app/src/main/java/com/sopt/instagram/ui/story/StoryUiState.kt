package com.sopt.instagram.ui.story

sealed class StoryUiState {
    data class ChangeMember(val index: Int) : StoryUiState()
    object Finish : StoryUiState()
}
