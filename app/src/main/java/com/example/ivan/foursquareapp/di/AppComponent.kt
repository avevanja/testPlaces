package com.example.ivan.foursquareapp.di

import com.example.ivan.foursquareapp.presentation.detailInfo.DetailInfoPresenter
import com.example.ivan.foursquareapp.presentation.places.PlacesPresenter
import dagger.Component

@Component(modules = [(PlaceModule::class)])
interface AppComponent {


    fun inject(placesPresenter: PlacesPresenter)

    fun inject(detailInfo: DetailInfoPresenter)

}