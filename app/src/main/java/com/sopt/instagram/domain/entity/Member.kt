package com.sopt.instagram.domain.entity

import java.io.Serializable

data class Member(
    val id: Int,
    val profileImage: String,
    val name: String,
) : Serializable
