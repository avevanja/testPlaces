package com.example.ivan.foursquareapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class DetailInfoResponse(

        @SerializedName("response")
        @Expose
        var response: DetailResponse? = null

)

data class DetailResponse(

        @SerializedName("venue")
        @Expose
        var venue: DetailVenue? = null
)

data class DetailVenue(

        @SerializedName("id")
        @Expose
        var id: String? = null,
        @SerializedName("name")
        @Expose
        var name: String? = null,
        @SerializedName("stats")
        @Expose
        var stats: Stats? = null,
        @SerializedName("likes")
        @Expose
        var likes: Likes? = null,
        @SerializedName("rating")
        @Expose
        var rating: Double? = null,
        @SerializedName("ratingColor")
        @Expose
        var ratingColor: String? = null,
        @SerializedName("photos")
        @Expose
        var photos: Photos? = null,
        @SerializedName("tips")
        @Expose
        var tips: Tips? = null

)

data class Stats(

        @SerializedName("visitsCount")
        @Expose
        var visitsCount: Int? = null

)

data class Likes(

        @SerializedName("count")
        @Expose
        var count: Int? = null

)

data class Photos(

        @SerializedName("groups")
        @Expose
        var groups: List<Group>? = null

)

data class Group(

        @SerializedName("items")
        @Expose
        var items: List<ItemPhotos>? = null

)

data class ItemPhotos(

        @SerializedName("prefix")
        @Expose
        var prefix: String? = null,
        @SerializedName("suffix")
        @Expose
        var suffix: String? = null

)

data class Tips(

        @SerializedName("groups")
        @Expose
        var groups: List<GroupTips>? = null

)

data class GroupTips(

        @SerializedName("items")
        @Expose
        var items: List<ItemTips>? = null

)

data class ItemTips(

        @SerializedName("text")
        @Expose
        var text: String? = null

)
