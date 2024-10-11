package com.example.data.repository

import androidx.paging.PagingData
import com.example.model.User
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    suspend fun searchUsers(query: String): Flow<PagingData<User>>
}