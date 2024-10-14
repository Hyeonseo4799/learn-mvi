package com.example.githubapi

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.navigation.Route
import com.example.search.navigation.searchScreen
import com.example.user.navigation.navigateToUser
import com.example.user.navigation.userScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: Route = Route.Search,
    showSnackBar: (String) -> Unit
) {
    NavHost(navController, startDestination) {
        searchScreen(showSnackBar = showSnackBar, navigateToUser = navController::navigateToUser)
        userScreen(showSnackBar = showSnackBar)
    }
}