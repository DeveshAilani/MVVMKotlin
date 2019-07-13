package com.devesh.mvvm.kotlin.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {
    fun onStarted()
    fun onSuccess(response: LiveData<String>)
    fun onFailure(message: String   )
}