package com.example.ivan.foursquareapp.di

import com.example.ivan.foursquareapp.data.PlaceRepository
import dagger.Module
import dagger.Provides

@Module
class PlaceModule {

    @Provides
    fun providePlaceRepo(): PlaceRepository = PlaceRepository()
}