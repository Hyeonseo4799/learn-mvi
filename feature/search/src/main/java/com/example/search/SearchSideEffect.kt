package com.example.search

sealed class SearchSideEffect {
    data class ShowError(val message: String): SearchSideEffect()
}