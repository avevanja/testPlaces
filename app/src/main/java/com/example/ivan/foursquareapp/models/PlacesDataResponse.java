package com.example.ivan.foursquareapp.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlacesDataResponse {
    @SerializedName("groups")
    @Expose
    private List<GroupVenues> groups = null;

    public List<GroupVenues> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupVenues> groups) {
        this.groups = groups;
    }
}
