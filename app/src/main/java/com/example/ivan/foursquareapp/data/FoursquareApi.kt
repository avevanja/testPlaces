package com.example.ivan.foursquareapp.data


import com.example.ivan.foursquareapp.models.PlacesResponse

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoursquareApi {

    @GET("venues/explore")
    fun getPlaces(@QueryMap params: Map<String, String>): Single<PlacesResponse>
}
