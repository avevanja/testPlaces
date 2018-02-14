package com.example.ivan.foursquareapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.ivan.foursquareapp.R
import com.example.ivan.foursquareapp.presentation.auth.LoginPresenter
import com.example.ivan.foursquareapp.presentation.auth.LoginView
import com.example.ivan.foursquareapp.utils.getIsLogin
import com.facebook.CallbackManager
import com.facebook.FacebookException
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : MvpAppCompatActivity(), LoginView {

    @InjectPresenter
    lateinit var mPresenter: LoginPresenter
    private var mCallbackManager: CallbackManager? = null

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, LoginActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCallbackManager = CallbackManager.Factory.create()
        setContentView(R.layout.activity_login)
        initUi()
        if (getIsLogin())
            successLogin()
    }


    private fun initUi() {
        loginButton.setOnClickListener { mPresenter.login(this, mCallbackManager) }
    }

    override fun successLogin() {
        PlacesActivity.start(this)
        finish()
    }

    private fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    override fun cancelLogin() {
        toast(getString(R.string.cancel_login))
    }

    override fun errorLogin(exception: FacebookException) {
        toast(exception.localizedMessage)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null) {
            mCallbackManager!!.onActivityResult(requestCode, resultCode, data)
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}
