package com.example.data.datasource

import com.example.network.dto.UserResponse

internal interface GithubDataSource {
    suspend fun searchUsers(query: String, page: Int): UserResponse
}