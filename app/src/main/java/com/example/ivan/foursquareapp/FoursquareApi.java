package com.example.ivan.foursquareapp;


import com.example.ivan.foursquareapp.models.PlacesResponse;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface FoursquareApi {

    @GET("venues/explore")
    Single<PlacesResponse> getPlaces(@QueryMap() Map<String, String> params);
}
