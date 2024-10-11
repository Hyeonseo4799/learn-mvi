package com.example.data.di

import com.example.data.datasource.GithubDataSource
import com.example.data.datasource.GithubDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataSourceModule {
    @Binds
    fun bindsGithubDataSource(
        githubDataSourceImpl: GithubDataSourceImpl
    ): GithubDataSource
}