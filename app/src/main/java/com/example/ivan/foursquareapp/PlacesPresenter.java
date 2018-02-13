package com.example.ivan.foursquareapp;


import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ivan.foursquareapp.models.PlacesResponse;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class PlacesPresenter extends MvpPresenter<PlacesView> {

    public void getPlaces(double lat, double lng) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("client_id", Constants.CLIENT_ID);
        parameters.put("client_secret", Constants.CLIENT_SECRET);
        parameters.put("v", "20170213");
        parameters.put("radius", "2000");
        parameters.put("near", "Львов");
        parameters.put("venuePhotos", "1");
        RetrofitBuilder.getFoursquareApiWithRx().getPlaces(parameters)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<PlacesResponse>() {
                    @Override
                    public void onSuccess(PlacesResponse placesResponse) {
                        getViewState().getPlaces(placesResponse.getResponse().getGroups().get(0).getItems());
                    }

                    @Override
                    public void onError(Throwable e) {
                        getViewState().errorGetPlaces(e.getLocalizedMessage());
                    }
                });
    }
}
