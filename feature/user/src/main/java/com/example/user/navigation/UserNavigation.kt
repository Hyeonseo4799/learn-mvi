package com.example.user.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.navigation.Route
import com.example.user.UserRoute

fun NavController.navigateToUser(query: String) {
    this.navigate(Route.User(query))
}

fun NavGraphBuilder.userScreen(showSnackBar: (String) -> Unit) {
    composable<Route.User> { backStackEntry ->
        val user = backStackEntry.toRoute<Route.User>()
        UserRoute(showSnackBar = showSnackBar, query = user.query)
    }
}