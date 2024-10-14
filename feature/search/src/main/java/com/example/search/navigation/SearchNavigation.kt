package com.example.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Route
import com.example.search.SearchRoute

fun NavGraphBuilder.searchScreen(
    showSnackBar: (String) -> Unit,
    navigateToUser: (String) -> Unit,
) {
    composable<Route.Search> {
        SearchRoute(showSnackBar = showSnackBar, navigateToUser = navigateToUser)
    }
}