package com.example.githubapi

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.navigation.Route
import com.example.search.navigation.searchScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: Route = Route.Search,
    showSnackBar: (String) -> Unit
) {
    NavHost(navController, startDestination) {
        searchScreen(showSnackBar = showSnackBar)
    }
}