package com.example.user

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
class UserViewModel @Inject constructor(
    private val searchUsersUseCase: SearchUsersUseCase
): ContainerHost<UserState, UserSideEffect>, ViewModel() {
    override val container = container<UserState, UserSideEffect>(UserState())

    fun searchUsers(query: String) = intent {
        reduce { state.copy(isLoading = true) }
        val users = searchUsersUseCase(query)
            .catch {
                reduce { state.copy(error = it.message.toString()) }
                postSideEffect(UserSideEffect.ShowError(state.error))
            }
            .cachedIn(viewModelScope)

        reduce { state.copy(users = users, isLoading = false) }
    }
}