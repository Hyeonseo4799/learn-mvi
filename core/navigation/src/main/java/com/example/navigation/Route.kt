package com.example.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Search: Route

    @Serializable
    data class User(val query: String): Route
}