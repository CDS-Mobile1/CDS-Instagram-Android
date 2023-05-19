package com.sopt.instagram.data.service
import com.sopt.instagram.data.model.response.DmResponseDTO
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface DmService {
    @GET("~/api/friend/favorites/stories")
    suspend fun getStories(
        @Body request: DmResponseDTO,
    ): BaseResponse<DmResponseDTO>
}
