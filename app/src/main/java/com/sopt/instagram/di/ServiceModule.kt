package com.sopt.instagram.di

import com.sopt.instagram.data.service.StoryService
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
    fun providesStoryService(retrofit: Retrofit): StoryService =
        retrofit.create(StoryService::class.java)
}
