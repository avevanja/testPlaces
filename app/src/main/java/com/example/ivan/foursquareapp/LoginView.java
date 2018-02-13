package com.example.ivan.foursquareapp;

import com.arellomobile.mvp.MvpView;
import com.facebook.FacebookException;

public interface LoginView extends MvpView {

    void successLogin();

    void cancelLogin();

    void errorLogin(FacebookException exception);
}
