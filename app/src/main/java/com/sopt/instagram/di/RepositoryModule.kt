package com.sopt.instagram.di

import com.sopt.instagram.data.repository.GetFriendStoriesRepositoryImpl
import com.sopt.instagram.data.repository.GetPostRepositoryImpl
import com.sopt.instagram.domain.repository.GetFriendStoriesRepository
import com.sopt.instagram.domain.repository.GetPostRepository
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
    abstract fun bindsGetPostRepository(
        getPostRepositoryImpl: GetPostRepositoryImpl,
    ): GetPostRepository

    @Binds
    @Singleton
    abstract fun bindsGetFriendStories(
        getFriendStoriesRepositoryImpl: GetFriendStoriesRepositoryImpl,
    ): GetFriendStoriesRepository
}
