package com.example.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.user.component.UserProfile
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun UserRoute(
    showSnackBar: (String) -> Unit,
    query: String,
    viewModel: UserViewModel = hiltViewModel(),
) {
    val uiState by viewModel.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.searchUsers(query = query)
    }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is UserSideEffect.ShowError -> showSnackBar(sideEffect.message)
        }
    }

    UserScreen(uiState = uiState)
}

@Composable
internal fun UserScreen(
    uiState: UserState,
) {
    val users = uiState.users.collectAsLazyPagingItems()
    val uriHandler = LocalUriHandler.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(
            count = users.itemCount,
            key = users.itemKey { it.id }
        ) {
            val user = users[it]

            if (user != null) {
                UserProfile(
                    username = user.login,
                    imageUrl = user.avatarUrl,
                    onClick = { uriHandler.openUri(user.url) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun UserScreenPreview() {
    UserScreen(uiState = UserState())
}