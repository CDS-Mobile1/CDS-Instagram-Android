package com.sopt.instagram.ui.newpost

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.instagram.data.model.request.NewPostRequestDto
import com.sopt.instagram.domain.repository.PostNewPostRepository
import com.sopt.instagram.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NewPostViewModel @Inject constructor(
    private val postNewPostService: PostNewPostRepository,
) : ViewModel() {
//    val contentText = MutableLiveData("")

    private val _postNewPostState = MutableLiveData<UiState>()
    val postNewPostState: LiveData<UiState> get() = _postNewPostState

    val mockImage = listOf(
        "https://reqres.in/img/faces/7-image.jpg",
        "https://reqres.in/img/faces/8-image.jpg",
        "https://reqres.in/img/faces/9-image.jpg",
    )

    fun onClickCheckButton(contentText: String) {
        viewModelScope.launch {
            postNewPostService.postNewPost(
                NewPostRequestDto(
                    contentText,
                    mockImage,
                ),
            )
                .onSuccess { NewPost ->
                    _postNewPostState.value = UiState.Success
                }
                .onFailure { Throwable ->
                    _postNewPostState.value = UiState.Failure(null)
                    Timber.d(Throwable)
                }
        }
    }
}
