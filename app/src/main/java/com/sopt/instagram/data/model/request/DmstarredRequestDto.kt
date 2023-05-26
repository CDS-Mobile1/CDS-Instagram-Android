package com.sopt.instagram.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DmstarredRequestDto(

    @SerialName("isFavorites")
    val isFavorites: Boolean
)
