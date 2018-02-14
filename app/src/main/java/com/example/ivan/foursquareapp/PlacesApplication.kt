package com.example.ivan.foursquareapp

import android.app.Application
import com.example.ivan.foursquareapp.di.AppComponent
import com.example.ivan.foursquareapp.di.DaggerAppComponent
import com.example.ivan.foursquareapp.di.PlaceModule


class PlacesApplication:Application(){
    companion object {
        @JvmStatic lateinit var graph: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        graph = DaggerAppComponent.builder().placeModule(PlaceModule()).build()
    }

}
