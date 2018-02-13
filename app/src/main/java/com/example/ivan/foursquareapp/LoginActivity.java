package com.example.ivan.foursquareapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.facebook.CallbackManager;
import com.facebook.FacebookException;


public class LoginActivity extends MvpAppCompatActivity implements LoginView{

    @InjectPresenter
    LoginPresenter mPresenter;
    private Button mLoginButton;
    private CallbackManager mCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCallbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);
        initUi();
    }

    public void initUi(){
        mLoginButton = findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(v -> mPresenter.login(this, mCallbackManager));

    }

    @Override
    public void successLogin() {
        PlacesActivity.start(this);
        finish();
    }

    @Override
    public void cancelLogin() {
        Toast.makeText(this, R.string.cancel_login, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorLogin(FacebookException exception) {
        Toast.makeText(this, exception.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}
