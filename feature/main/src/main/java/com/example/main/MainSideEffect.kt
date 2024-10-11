package com.example.main

sealed class MainSideEffect {
    data class ShowError(val message: String): MainSideEffect()
}