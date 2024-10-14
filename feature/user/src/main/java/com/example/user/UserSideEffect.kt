package com.example.user

sealed class UserSideEffect {
    data class ShowError(val message: String): UserSideEffect()
}