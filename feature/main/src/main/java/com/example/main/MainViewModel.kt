package com.example.main

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
class MainViewModel @Inject constructor(
    private val searchUsersUseCase: SearchUsersUseCase
) : ContainerHost<MainState, MainSideEffect>, ViewModel() {
    override val container = container<MainState, MainSideEffect>(MainState())

    fun searchUsers(query: String) = intent {
        reduce { state.copy(isLoading = true) }

        val users = searchUsersUseCase(query)
            .cachedIn(viewModelScope)
            .catch {
                reduce { state.copy(error = it.message.toString()) }
                postSideEffect(MainSideEffect.ShowError(it.message.toString()))
            }

        reduce { state.copy(isLoading = false, users = users) }
    }
}