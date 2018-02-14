package com.example.ivan.foursquareapp.presentation.places

import com.arellomobile.mvp.MvpView
import com.example.ivan.foursquareapp.entity.ItemVenue


interface PlacesView : MvpView {

    fun getPlaces(list: List<ItemVenue>)

    fun errorGetPlaces(message: String)
}
