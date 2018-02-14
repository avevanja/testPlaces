@file:JvmName("PrefUtils")

package com.example.ivan.foursquareapp.utils

import android.content.Context
import com.example.ivan.foursquareapp.PlacesApplication


private val prefs by lazy {
    PlacesApplication.context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
}

fun getIsLogin(): Boolean = prefs.getBoolean("is_login", false)

fun setIsLogin(isLogin: Boolean) {
    prefs.edit().putBoolean("is_login", isLogin).apply()
}