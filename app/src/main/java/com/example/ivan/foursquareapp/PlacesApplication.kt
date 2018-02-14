package com.example.ivan.foursquareapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.ivan.foursquareapp.di.AppComponent
import com.example.ivan.foursquareapp.di.DaggerAppComponent
import com.example.ivan.foursquareapp.di.PlaceModule


class PlacesApplication:Application(){
    companion object {
        @JvmStatic lateinit var graph: AppComponent
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }


    override fun onCreate() {
        super.onCreate()
        graph = DaggerAppComponent.builder().placeModule(PlaceModule()).build()
        context = this
    }

}
