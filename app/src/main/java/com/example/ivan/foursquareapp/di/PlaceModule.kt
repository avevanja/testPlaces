package com.example.ivan.foursquareapp.di

import com.example.ivan.foursquareapp.model.repository.DetailInfoRepository
import com.example.ivan.foursquareapp.model.repository.PlaceRepository
import dagger.Module
import dagger.Provides

@Module
class PlaceModule {

    @Provides
    fun providePlaceRepo(): PlaceRepository = PlaceRepository()

    @Provides
    fun provideDetailRepo(): DetailInfoRepository = DetailInfoRepository()
}