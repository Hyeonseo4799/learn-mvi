package com.example.githubapi

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.main.navigation.MainRoute
import com.example.main.navigation.mainScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: String = MainRoute,
    showSnackBar: (String) -> Unit
) {
    NavHost(navController, startDestination) {
        mainScreen(showSnackBar = showSnackBar)
    }
}