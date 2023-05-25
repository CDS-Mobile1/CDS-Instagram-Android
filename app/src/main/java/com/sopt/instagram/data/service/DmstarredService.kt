package com.sopt.instagram.data.service

import com.sopt.instagram.data.model.request.DmstarredRequestDto
import com.sopt.instagram.data.model.response.wrapper.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface DmstarredService {
    @POST("api/friend/favorites/{memberId}")
    suspend fun getstarred(
        @Body request: DmstarredRequestDto,
        @Path("memberId") memberId: Int,
    ): BaseResponse<Unit>
}
