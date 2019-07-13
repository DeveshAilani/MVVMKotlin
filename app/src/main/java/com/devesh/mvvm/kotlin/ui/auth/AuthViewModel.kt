package com.devesh.mvvm.kotlin.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.devesh.mvvm.kotlin.data.repositories.UserRepository

class AuthViewModel : ViewModel() {

    // email and password is initialized as 'null' with null safety operator '?'
    var email: String? = null
    var password: String? = null

    var authListener:AuthListener? = null

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }

        // In this ViewModel we are creating instance of Repository which is making AuthVM dependent on repository
        // This bad practice which we will resolve using DI (Dependency Injection)
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }
}