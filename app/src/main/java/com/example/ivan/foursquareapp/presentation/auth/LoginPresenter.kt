package com.example.ivan.foursquareapp.presentation.auth


import android.app.Activity

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult



@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {


    fun login(context: Activity, callbackManager: CallbackManager?) {

        val loginManager = LoginManager.getInstance()
        loginManager.logInWithReadPermissions(context, listOf("public_profile"))
        loginManager.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                viewState.successLogin()
            }

            override fun onCancel() {
                viewState.cancelLogin()
            }

            override fun onError(error: FacebookException) {
                viewState.errorLogin(error)
            }
        })
    }


}
