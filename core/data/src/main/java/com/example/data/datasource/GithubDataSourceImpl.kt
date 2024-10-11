package com.example.data.datasource

import com.example.network.api.GithubApi
import com.example.network.dto.UserResponse
import javax.inject.Inject

internal class GithubDataSourceImpl @Inject constructor(
    private val githubApi: GithubApi
): GithubDataSource {
    override suspend fun searchUsers(query: String, page: Int): UserResponse {
        return githubApi.searchUsers(query, page)
    }
}