package com.example.ivan.foursquareapp;


import android.app.Activity;
import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Collections;


@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {


    public void login(Activity context, CallbackManager callbackManager) {

        LoginManager loginManager = LoginManager.getInstance();
        loginManager.logInWithReadPermissions(context, Collections.singletonList("public_profile"));
        loginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                getViewState().successLogin();
            }

            @Override
            public void onCancel() {
                getViewState().cancelLogin();
            }

            @Override
            public void onError(FacebookException error) {
                getViewState().errorLogin(error);
            }
        });
    }


}
