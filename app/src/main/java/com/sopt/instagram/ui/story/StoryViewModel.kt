package com.sopt.instagram.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.instagram.domain.entity.Member
import com.sopt.instagram.ui.story.StoryUiState.ChangeMember
import com.sopt.instagram.ui.story.StoryUiState.Finish
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor() : ViewModel() {
    private val _storyState = MutableLiveData<StoryUiState>()
    val storyState: LiveData<StoryUiState>
        get() = _storyState

    private val _memberList = MutableLiveData<List<Member>>()
    val memberList: List<Member>
        get() = _memberList.value ?: emptyList()

    val currentMember = MutableLiveData<Member>()

    init {
        getMember()
    }

    private fun getMember() {
        // TODO: 서버 통신으로 스토리 멤버 리스트 가져오기
        val members = listOf(
            Member(
                id = 1,
                profileImage = "https://user-images.githubusercontent.com/70993562/210304413-00952aa3-4faa-46a8-bacf-b94df2cc0499.jpg",
                name = "booknuts",
            ),
            Member(
                id = 2,
                profileImage = "https://avatars.githubusercontent.com/u/121111592?s=280&v=4",
                name = "keyneez",
            ),
            Member(
                id = 3,
                profileImage = "https://github.com/GO-SOPT-ANDROID/chaeyeon-jeon/assets/70993562/7366307d-b001-42b6-a2cc-06bddfaa40dd",
                name = "sujung_village",
            ),
        )
        _memberList.value = members
    }

    fun setCurrentMember(index: Int) {
        if (index !in memberList.indices) {
            _storyState.value = Finish
            return
        }
        currentMember.value = memberList[index]
        _storyState.value = ChangeMember(index)
    }
}
