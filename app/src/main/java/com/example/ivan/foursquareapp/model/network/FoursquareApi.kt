package com.example.ivan.foursquareapp.model.network


import com.example.ivan.foursquareapp.entity.DetailInfoResponse
import com.example.ivan.foursquareapp.entity.PlacesResponse

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface FoursquareApi {

    @GET("venues/explore")
    fun getPlaces(@QueryMap params: Map<String, String>): Single<PlacesResponse>

    @GET("venues/{id}")
    fun getDetailInfo(@Path("id") id: String, @QueryMap params: Map<String, String>): Single<DetailInfoResponse>
}
