package com.example.search

import androidx.paging.PagingData
import com.example.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class SearchState(
    val isLoading: Boolean = false,
    val users: Flow<PagingData<User>> = flow { PagingData.empty<User>() },
    val error: String = ""
)
