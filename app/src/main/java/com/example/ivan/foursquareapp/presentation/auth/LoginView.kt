package com.example.ivan.foursquareapp.presentation.auth

import com.arellomobile.mvp.MvpView
import com.facebook.FacebookException

interface LoginView : MvpView {

    fun successLogin()

    fun cancelLogin()

    fun errorLogin(exception: FacebookException)
}
