package com.sopt.instagram.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.instagram.domain.entity.FriendStory
import com.sopt.instagram.domain.entity.Post
import com.sopt.instagram.domain.repository.GetFriendStoriesRepository
import com.sopt.instagram.domain.repository.GetPostRepository
import com.sopt.instagram.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostRepository: GetPostRepository,
    private val getFriendStoriesRepository: GetFriendStoriesRepository,
) : ViewModel() {
    private val _postList = MutableLiveData<List<Post>>()
    val postList: LiveData<List<Post>>
        get() = _postList

    private val _getPostListState = MutableLiveData<UiState>()
    val getPostListState: LiveData<UiState> get() = _getPostListState

    private val _friendStoryList = MutableLiveData<List<FriendStory>>()
    val friendStoryList: LiveData<List<FriendStory>> get() = _friendStoryList

    private val _getFriendStoriesListState = MutableLiveData<UiState>()
    val getFriendStoriesListState: LiveData<UiState> get() = _getFriendStoriesListState

    init {
        getPostList()
        getFriendStoriesList()
    }

    fun getPostList() {
        viewModelScope.launch {
            getPostRepository.getPostList()
                .onSuccess { response ->
                    _postList.value = response
                    _getPostListState.value = UiState.Success
                    Timber.tag("getPostListSuccess").d(response?.toString())
                }
                .onFailure {
                    _getPostListState.value = UiState.Failure(null)
                    Timber.tag("getPostFailure").d(it)
                }
        }
    }

    fun getFriendStoriesList() {
        viewModelScope.launch {
            getFriendStoriesRepository.getFriendStories()
                .onSuccess { response ->
                    _friendStoryList.value = response
                    _getFriendStoriesListState.value = UiState.Success
                }
                .onFailure {
                    _getFriendStoriesListState.value = UiState.Failure(null)
                    Timber.tag("getFriendStoriesList").d(it)
                }
        }
    }
}
