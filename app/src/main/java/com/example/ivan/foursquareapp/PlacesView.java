package com.example.ivan.foursquareapp;

import com.arellomobile.mvp.MvpView;
import com.example.ivan.foursquareapp.models.ItemVenue;

import java.util.List;


public interface PlacesView extends MvpView {

    void getPlaces(List<ItemVenue> list);

    void errorGetPlaces(String message);
}
