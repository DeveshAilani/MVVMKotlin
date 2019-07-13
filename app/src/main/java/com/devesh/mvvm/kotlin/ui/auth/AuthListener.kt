package com.devesh.mvvm.kotlin.ui.auth

import androidx.lifecycle.LiveData
import com.devesh.mvvm.kotlin.data.database.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String   )
}