package com.example.ivan.foursquareapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Hours {
    @SerializedName("isOpen")
    @Expose
    private Boolean isOpen;

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }
}
