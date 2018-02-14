package com.example.ivan.foursquareapp.presentation

import com.arellomobile.mvp.MvpView
import com.example.ivan.foursquareapp.models.DetailVenue


interface DetailInfoView : MvpView {

    fun getDetailInfo(venue: DetailVenue)
    fun errorGetInfo(error: String)
}
