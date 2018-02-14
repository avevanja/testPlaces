package com.example.ivan.foursquareapp.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PlacesResponse(

        @SerializedName("response")
        @Expose
        var response: PlacesDataResponse? = null
)


data class Venue(

        @SerializedName("id")
        @Expose
        var id: String? = null,
        @SerializedName("name")
        @Expose
        var name: String? = null,
        @SerializedName("contact")
        @Expose
        var contact: Contact? = null,
        @SerializedName("rating")
        @Expose
        var rating: Double? = null,
        @SerializedName("ratingSignals")
        @Expose
        var ratingSignals: Int? = null,
        @SerializedName("hours")
        @Expose
        var hours: Hours? = null,
        @SerializedName("photos")
        @Expose
        var photos: PhotosVenue? = null
)

data class Contact(
        @SerializedName("phone")
        @Expose
        var phone: String? = null,
        @SerializedName("formattedPhone")
        @Expose
        var formattedPhone: String? = null
)

data class GroupPhoto(
        @SerializedName("items")
        @Expose
        var items: List<ItemPhoto>
)

data class GroupVenues(
        @SerializedName("items")
        @Expose
        var items: List<ItemVenue>? = null
)

data class Hours(
        @SerializedName("isOpen")
        @Expose
        val isOpen: Boolean
)

data class ItemPhoto(
        @SerializedName("prefix")
        @Expose
        var prefix: String? = null,
        @SerializedName("suffix")
        @Expose
        var suffix: String? = null
)

data class ItemVenue(
        @SerializedName("venue")
        @Expose
        var venue: Venue? = null
)


data class PhotosVenue(
        @SerializedName("groups")
        @Expose
        val groups: List<GroupPhoto>
)


data class PlacesDataResponse(
        @SerializedName("groups")
        @Expose
        var groups: List<GroupVenues>? = null
)





