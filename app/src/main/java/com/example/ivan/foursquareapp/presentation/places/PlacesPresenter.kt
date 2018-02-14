package com.example.ivan.foursquareapp.presentation.places


import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.ivan.foursquareapp.utils.Constants
import com.example.ivan.foursquareapp.PlacesApplication
import com.example.ivan.foursquareapp.model.repository.PlaceRepository
import com.example.ivan.foursquareapp.entity.PlacesResponse

import java.util.HashMap

import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

@InjectViewState
class PlacesPresenter : MvpPresenter<PlacesView>() {

    @Inject
    lateinit var mPlaceRepo: PlaceRepository

    init {
        PlacesApplication.graph.inject(this)
    }

    fun getPlaces(lat: Double, lng: Double) {
        val parameters = HashMap<String, String>()
        parameters["client_id"] = Constants.CLIENT_ID
        parameters["client_secret"] = Constants.CLIENT_SECRET
        parameters["v"] = "20170213"
        parameters["radius"] = "2000"
        parameters["ll"] = lat.toString() + "," + lng.toString()
        parameters["venuePhotos"] = "1"
        mPlaceRepo.getPlaces(parameters)
                .subscribeWith(object : DisposableSingleObserver<PlacesResponse>() {
                    override fun onSuccess(placesResponse: PlacesResponse) {
                        viewState.getPlaces(placesResponse.response!!.groups!![0].items!!)
                    }

                    override fun onError(e: Throwable) {
                        viewState.errorGetPlaces(e.localizedMessage)
                    }
                })
    }
}
