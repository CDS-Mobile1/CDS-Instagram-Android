package com.sopt.instagram.ui.story.member

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.instagram.domain.entity.Story
import com.sopt.instagram.domain.repository.StoryRepository
import com.sopt.instagram.ui.story.member.MemberStoryUiState.GetMemberStorySuccess
import com.sopt.instagram.ui.story.member.MemberStoryUiState.NextMember
import com.sopt.instagram.ui.story.member.MemberStoryUiState.NextStory
import com.sopt.instagram.ui.story.member.MemberStoryUiState.PreviousMember
import com.sopt.instagram.ui.story.member.MemberStoryUiState.PreviousStory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MemberStoryViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
) : ViewModel() {
    private val _storyState = MutableLiveData<MemberStoryUiState>()
    val storyState: LiveData<MemberStoryUiState>
        get() = _storyState

    private val _storyList = MutableLiveData<List<Story>>()
    val storyList: List<Story>
        get() = _storyList.value ?: emptyList()

    private val _storyIndex = MutableLiveData<Int>()
    val storyIndex: Int
        get() = _storyIndex.value ?: 0

    val currentStory = MutableLiveData<Story>()

    init {
        getStory()
    }

    private fun getStory() {
        viewModelScope.launch {
            storyRepository.getMemberStory(3)
                .onSuccess { stories ->
                    Timber.d("GET MEMBER STORY SUCCESS : $stories")
                    _storyList.value = stories
                    _storyIndex.value = 0
                    setCurrentStory()
                    _storyState.value = GetMemberStorySuccess
                }
                .onFailure { throwable ->
                    Timber.e("GET MEMBER STORY FAILURE : $throwable")
                }
        }
    }

    fun setCurrentStory() {
        currentStory.value = storyList[storyIndex]
    }

    fun increaseStoryIndex() {
        if (storyIndex == storyList.size - 1) {
            _storyState.value = NextMember
            return
        }
        _storyIndex.value = _storyIndex.value?.plus(1)
        _storyState.value = NextStory
    }

    fun decreaseStoryIndex() {
        if (storyIndex == 0) {
            _storyState.value = PreviousMember
            return
        }
        _storyIndex.value = _storyIndex.value?.minus(1)
        _storyState.value = PreviousStory
    }
}
