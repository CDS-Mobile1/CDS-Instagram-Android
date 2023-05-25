package com.sopt.instagram.di

import com.sopt.instagram.data.service.GetPostService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun getPostService(retrofit: Retrofit): GetPostService =
        retrofit.create(GetPostService::class.java)
}
