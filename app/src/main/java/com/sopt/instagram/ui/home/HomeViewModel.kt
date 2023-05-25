package com.sopt.instagram.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.instagram.domain.entity.GetPostEntity
import com.sopt.instagram.domain.repository.GetPostRepository
import com.sopt.instagram.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostRepository: GetPostRepository,
) : ViewModel() {
    private val _postList = MutableLiveData<List<GetPostEntity>>()
    val postList: LiveData<List<GetPostEntity>>
        get() = _postList

    private val _getPostListState = MutableLiveData<UiState>()
    val getPostListState: LiveData<UiState> get() = _getPostListState

    // 서버 통신
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
}
