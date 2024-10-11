package com.example.data.di

import com.example.data.repository.GithubRepository
import com.example.data.repository.GithubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    @Binds
    fun bindsGithubRepository(
        githubRepositoryImpl: GithubRepositoryImpl
    ): GithubRepository
}