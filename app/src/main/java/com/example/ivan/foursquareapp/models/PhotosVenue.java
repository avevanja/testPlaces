package com.example.ivan.foursquareapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


class PhotosVenue {
    @SerializedName("groups")
    @Expose
    private List<GroupPhoto> groups = null;

    public List<GroupPhoto> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupPhoto> groups) {
        this.groups = groups;
    }
}
