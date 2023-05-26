package com.sopt.instagram.ui.story.tag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.instagram.domain.entity.Tag
import com.sopt.instagram.domain.repository.StoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TagViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
) : ViewModel() {
    private val _tagList = MutableLiveData<List<Tag>>()
    val tagList: LiveData<List<Tag>>
        get() = _tagList

    fun getTagList(storyIndex: Int) {
        viewModelScope.launch {
            storyRepository.getTaggedMember(storyIndex)
                .onSuccess { tagList ->
                    Timber.d("GET TAGGED MEMBER SUCCESS($storyIndex) : $tagList")
                    _tagList.value = tagList
                }
                .onFailure { throwable ->
                    Timber.e("GET TAGGED MEMBER FAILURE : $throwable")
                }
        }
    }
}
