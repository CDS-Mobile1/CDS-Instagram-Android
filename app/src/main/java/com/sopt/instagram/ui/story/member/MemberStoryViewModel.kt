package com.sopt.instagram.ui.story.member

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.instagram.domain.entity.Story
import com.sopt.instagram.ui.story.member.StoryState.NextMember
import com.sopt.instagram.ui.story.member.StoryState.NextStory
import com.sopt.instagram.ui.story.member.StoryState.PreviousMember
import com.sopt.instagram.ui.story.member.StoryState.PreviousStory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemberStoryViewModel @Inject constructor() : ViewModel() {
    private val _storyState = MutableLiveData<StoryState>()
    val storyState: LiveData<StoryState>
        get() = _storyState

    private val _storyList = MutableLiveData<List<Story>>()
    val storyList: List<Story>
        get() = _storyList.value ?: emptyList()

    private val _storyIndex = MutableLiveData<Int>()
    val storyIndex: LiveData<Int>
        get() = _storyIndex

    val currentStory = MutableLiveData<Story>()

    init {
        getStory()
    }

    private fun getStory() {
        val list = listOf(
            Story(
                id = 1,
                image = "https://user-images.githubusercontent.com/70744494/212153469-efeab9d1-927c-4937-8778-e27bf262510b.png",
                time = "2분",
            ),
            Story(
                id = 2,
                image = "https://github.com/Keyneez/Keyneez-AOS/assets/70993562/6ad1249e-c942-469a-83b0-1d85dac165bf",
                time = "43분",
            ),
            Story(
                id = 3,
                image = "https://github.com/GO-SOPT-ANDROID/chaeyeon-jeon/assets/70993562/6873f285-6938-4622-a0df-be1e23db9a9a",
                time = "3시간",
            ),
        )
        _storyList.value = list
        _storyIndex.value = 0
        setCurrentStory()
    }

    fun setCurrentStory() {
        currentStory.value = storyList[storyIndex.value ?: 0]
    }

    fun increaseStoryIndex() {
        if (storyIndex.value == storyList.size - 1) {
            _storyState.value = NextMember
            return
        }
        _storyIndex.value = _storyIndex.value?.plus(1)
        _storyState.value = NextStory
    }

    fun decreaseStoryIndex() {
        if (storyIndex.value == 0) {
            _storyState.value = PreviousMember
            return
        }
        _storyIndex.value = _storyIndex.value?.minus(1)
        _storyState.value = PreviousStory
    }
}
