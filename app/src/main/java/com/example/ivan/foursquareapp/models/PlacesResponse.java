package com.example.ivan.foursquareapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class PlacesResponse {
    @SerializedName("meta")
    @Expose
    private MetaResponse meta;
    @SerializedName("response")
    @Expose
    private PlacesDataResponse response;

    public MetaResponse getMeta() {
        return meta;
    }

    public void setMeta(MetaResponse meta) {
        this.meta = meta;
    }

    public PlacesDataResponse getResponse() {
        return response;
    }

    public void setResponse(PlacesDataResponse response) {
        this.response = response;
    }
}
