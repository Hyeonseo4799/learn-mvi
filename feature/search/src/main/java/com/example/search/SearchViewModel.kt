package com.example.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.domain.SearchUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ContainerHost<SearchState, SearchSideEffect>, ViewModel() {
    override val container = container<SearchState, SearchSideEffect>(SearchState())

    fun enterQuery(query: String) = intent {
        if (query.isNotEmpty()) {
            postSideEffect(SearchSideEffect.NavigateToUser(query))
        } else {
            reduce { state.copy(error = "query must not be empty") }
            postSideEffect(SearchSideEffect.ShowError(state.error))
        }
    }
}