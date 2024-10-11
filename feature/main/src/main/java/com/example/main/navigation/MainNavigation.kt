package com.example.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.main.MainRoute

const val MainRoute = "main_route"

fun NavGraphBuilder.mainScreen(
    showSnackBar: (String) -> Unit,
) {
    composable(MainRoute) {
        MainRoute(showSnackBar = showSnackBar)
    }
}