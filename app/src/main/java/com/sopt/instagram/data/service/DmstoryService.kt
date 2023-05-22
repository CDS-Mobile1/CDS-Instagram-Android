package com.sopt.instagram.data.service
import com.sopt.instagram.data.model.response.DmstoryResponseDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface DmstoryService {
    @GET("~/api/friend/favorites/stories")
    suspend fun getStories(
        @Body request: DmstoryResponseDto,
    ): BaseResponse<DmstoryResponseDto>
}
