package com.sopt.instagram.di

import com.sopt.instagram.data.repository.StoryRepositoryImpl
import com.sopt.instagram.domain.repository.StoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsStoryRepository(
        storyRepositoryImpl: StoryRepositoryImpl,
    ): StoryRepository
}
