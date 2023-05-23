package com.sopt.instagram.ui.story

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.instagram.domain.entity.Member
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor() : ViewModel() {
    val currentAuthor = MutableLiveData<Member>()

    init {
        getMember(0)
    }

    private fun getMember(index: Int) {
        val list = listOf(
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
        currentAuthor.value = list[index]
    }
}
