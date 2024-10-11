package com.example.domain

import androidx.paging.PagingData
import com.example.data.repository.GithubRepository
import com.example.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUsersUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    suspend operator fun invoke(query: String): Flow<PagingData<User>> {
        return githubRepository.searchUsers(query)
    }
}