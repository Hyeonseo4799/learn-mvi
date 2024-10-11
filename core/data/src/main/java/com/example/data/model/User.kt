package com.example.data.model

import com.example.network.dto.User

internal fun User.toUser() = com.example.model.User(
    login = login,
    id = id,
    avatarUrl = avatarUrl,
    url= url,
)