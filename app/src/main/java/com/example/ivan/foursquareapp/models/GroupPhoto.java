package com.example.ivan.foursquareapp.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupPhoto {
    @SerializedName("items")
    @Expose
    private List<ItemPhoto> items = null;

    public List<ItemPhoto> getItems() {
        return items;
    }

    public void setItems(List<ItemPhoto> items) {
        this.items = items;
    }
}
