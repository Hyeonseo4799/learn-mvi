package com.example.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.search.SearchRoute

const val SearchRoute = "search_route"

fun NavGraphBuilder.searchScreen(
    showSnackBar: (String) -> Unit,
) {
    composable(SearchRoute) {
        SearchRoute(showSnackBar = showSnackBar)
    }
}