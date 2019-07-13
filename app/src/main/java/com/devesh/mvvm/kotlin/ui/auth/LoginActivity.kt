package com.devesh.mvvm.kotlin.ui.auth

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devesh.mvvm.kotlin.R
import com.devesh.mvvm.kotlin.data.database.entities.User
import com.devesh.mvvm.kotlin.databinding.ActivityLoginBinding
import com.devesh.mvvm.kotlin.util.hide
import com.devesh.mvvm.kotlin.util.show
import com.devesh.mvvm.kotlin.util.toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.progress_bar
import kotlinx.android.synthetic.main.activity_signup.*

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val  viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
        //toast("Login Started")

        //progress_bar.visibility = View.VISIBLE
        //Now to make it sorter we can make extension fun to show and hide progress-bar
        progress_bar.show()
    }

    /*override fun onSuccess(response: LiveData<String>) {
        //toast("Login Success")

        response.observe(this, Observer {
            progress_bar.hide()
            toast(it)
        })
    }*/

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.name} is logged In")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast("Failed: $message")
    }
}
