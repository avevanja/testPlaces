package com.example.ivan.foursquareapp.model.repository

import com.example.ivan.foursquareapp.entity.PlacesResponse
import com.example.ivan.foursquareapp.model.network.RetrofitBuilder
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PlaceRepository {

    fun getPlaces(parameters: Map<String, String>): Single<PlacesResponse> {
        return RetrofitBuilder.foursquareApiWithRx.getPlaces(parameters)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}
