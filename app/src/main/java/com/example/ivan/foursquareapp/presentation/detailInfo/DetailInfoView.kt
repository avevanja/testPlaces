package com.example.ivan.foursquareapp.presentation.detailInfo

import com.arellomobile.mvp.MvpView
import com.example.ivan.foursquareapp.entity.DetailVenue


interface DetailInfoView : MvpView {

    fun getDetailInfo(venue: DetailVenue)
    fun errorGetInfo(error: String)
}
