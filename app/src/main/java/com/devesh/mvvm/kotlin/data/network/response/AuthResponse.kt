package com.devesh.mvvm.kotlin.data.network.response

import com.devesh.mvvm.kotlin.data.database.entities.User

data class AuthResponse (
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)