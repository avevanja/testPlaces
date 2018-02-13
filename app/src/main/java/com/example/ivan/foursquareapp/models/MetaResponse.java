package com.example.ivan.foursquareapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MetaResponse {
    @SerializedName("code")
    @Expose
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
