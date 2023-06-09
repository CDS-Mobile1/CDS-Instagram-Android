package com.sopt.instagram.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.instagram.BuildConfig
import com.sopt.instagram.data.service.DmlistService
import com.sopt.instagram.data.service.DmstarredService
import com.sopt.instagram.data.service.DmstoryService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiFactory {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object ServicePool {
    val dmstoryService = ApiFactory.create<DmstoryService>()
    val dmstarService = ApiFactory.create<DmstarredService>()
    val dmlistService = ApiFactory.create<DmlistService>()
}
