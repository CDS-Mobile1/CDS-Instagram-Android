package com.sopt.instagram.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.instagram.data.model.response.GetPostResponseDto

class HomeViewModel: ViewModel() {
    private val _postList = MutableLiveData<List<GetPostResponseDto>>()
    val postList: LiveData<List<GetPostResponseDto>>
        get() = _postList

    //서버 통신

    val mockPostList = listOf<GetPostResponseDto>(
        GetPostResponseDto(
            "여기는 게시글 내용이 들어가는 곳인데 이렇게 글이 길어지면 2단으로 위처럼 작성되며 그를 넘어서게 길어지면 ...으로 축약하여 보여주기",
            listOf<String>("https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/7-image.jpg"),
            GetPostResponseDto.UserInfo(1, "https://reqres.in/img/faces/7-image.jpg", "seonhwan")
        ),
        GetPostResponseDto(
            "여기는 게시글 내용이 들어가는 곳인데 이렇게 글이 길어지면 2단으로 위처럼 작성되며 그를 넘어서게 길어지면 ...으로 축약하여 보여주기",
            listOf<String>("https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/7-image.jpg"),
            GetPostResponseDto.UserInfo(1, "https://reqres.in/img/faces/7-image.jpg", "seonhwan")
        ),
        GetPostResponseDto(
            "여기는 게시글 내용이 들어가는 곳인데 이렇게 글이 길어지면 2단으로 위처럼 작성되며 그를 넘어서게 길어지면 ...으로 축약하여 보여주기",
            listOf<String>("https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/7-image.jpg"),
            GetPostResponseDto.UserInfo(1, "https://reqres.in/img/faces/7-image.jpg", "seonhwan")
        ),
        GetPostResponseDto(
            "여기는 게시글 내용이 들어가는 곳인데 이렇게 글이 길어지면 2단으로 위처럼 작성되며 그를 넘어서게 길어지면 ...으로 축약하여 보여주기",
            listOf<String>("https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/7-image.jpg", "https://reqres.in/img/faces/7-image.jpg"),
            GetPostResponseDto.UserInfo(1, "https://reqres.in/img/faces/7-image.jpg", "seonhwan")
        )
    )
}