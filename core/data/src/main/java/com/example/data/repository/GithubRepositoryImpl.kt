package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.datasource.GithubDataSource
import com.example.data.model.toUser
import com.example.data.paging.GithubPagingSource
import com.example.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class GithubRepositoryImpl @Inject constructor(
    private val githubDataSource: GithubDataSource
): GithubRepository {
    override suspend fun searchUsers(query: String): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(
                pageSize = 30,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                GithubPagingSource { page ->
                    githubDataSource.searchUsers(
                        query = query,
                        page = page
                    )
                }
            }
        ).flow.map { pagingData ->
            pagingData.map(com.example.network.dto.User::toUser)
        }
    }
}