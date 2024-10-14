package com.example.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("total_count") val total: Int,
    @SerialName("items") val users: List<User>,
)

@Serializable
data class User(
    @SerialName("login") val login: String,
    @SerialName("id") val id: Long,
    @SerialName("avatar_url") val avatarUrl: String,
    @SerialName("html_url") val url: String,
)
