package com.sopt.instagram.data.repository

import com.sopt.instagram.data.model.request.NewPostRequestDto
import com.sopt.instagram.data.source.PostNewPostSource
import com.sopt.instagram.domain.entity.NewPost
import com.sopt.instagram.domain.repository.PostNewPostRepository
import javax.inject.Inject

class PostNewPostRepositoryImpl @Inject constructor(
    private val postNewPostSource: PostNewPostSource,
) : PostNewPostRepository {
    override suspend fun postNewPost(newPostRequestDto: NewPostRequestDto): Result<NewPost> =
        runCatching {
            postNewPostSource.postNewPost(newPostRequestDto).toNewPost()
        }
}
