package com.example.ivan.foursquareapp.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class PlacesResponse {
    @SerializedName("meta")
    @Expose
    var meta: MetaResponse? = null
    @SerializedName("response")
    @Expose
    var response: PlacesDataResponse? = null
}

data class ItemResponse(

        @SerializedName("venue")
        @Expose
        var venue: Venue?,
        @SerializedName("tips")
        @Expose
        var tips: List<Tip>?
)

data class Venue(

        @SerializedName("name")
        @Expose
        var name: String? = null,
        @SerializedName("contact")
        @Expose
        var contact: Contact? = null,
        @SerializedName("stats")
        @Expose
        var stats: Stats? = null,
        @SerializedName("rating")
        @Expose
        var rating: Double? = null,
        @SerializedName("ratingSignals")
        @Expose
        var ratingSignals: Int? = null,
        @SerializedName("beenHere")
        @Expose
        var beenHere: BeenHere? = null,
        @SerializedName("hours")
        @Expose
        var hours: Hours? = null,
        @SerializedName("photos")
        @Expose
        var photos: PhotosVenue? = null
)

data class Tip(

        @SerializedName("text")
        @Expose
        var text: String? = null,
        @SerializedName("photo")
        @Expose
        var photo: PhotoTip? = null,
        @SerializedName("agreeCount")
        @Expose
        var agreeCount: Int? = null,
        @SerializedName("disagreeCount")
        @Expose
        var disagreeCount: Int? = null,
        @SerializedName("user")
        @Expose
        var user: User? = null) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readParcelable(PhotoTip::class.java.classLoader),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readParcelable(User::class.java.classLoader))


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(text)
        parcel.writeParcelable(photo, flags)
        parcel.writeValue(agreeCount)
        parcel.writeValue(disagreeCount)
        parcel.writeParcelable(user, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tip> {
        override fun createFromParcel(parcel: Parcel): Tip {
            return Tip(parcel)
        }

        override fun newArray(size: Int): Array<Tip?> {
            return arrayOfNulls(size)
        }
    }
}


data class BeenHere(
        @SerializedName("count")
        @Expose
        val count: Int? = null,
        @SerializedName("marked")
        @Expose
        val marked: Boolean? = null,
        @SerializedName("lastCheckinExpiredAt")
        @Expose
        val lastCheckinExpiredAt: Int? = null
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

class GroupVenues {
    @SerializedName("items")
    @Expose
    var items: List<ItemVenue>? = null
}

data class Hours(
        @SerializedName("isOpen")
        @Expose
        val isOpen: Boolean
)

class ItemPhoto {
    @SerializedName("prefix")
    @Expose
    var prefix: String? = null
    @SerializedName("suffix")
    @Expose
    var suffix: String? = null
}

class ItemVenue {
    @SerializedName("venue")
    @Expose
    var venue: Venue? = null
    @SerializedName("tips")
    @Expose
    var tips: List<Tip>? = null
}

data class MetaResponse(
        @SerializedName("code")
        @Expose
        var code: Int? = null
)

data class PhotosVenue(
        @SerializedName("groups")
        @Expose
        val groups: List<GroupPhoto>
)

data class PhotoTip(

        @SerializedName("prefix")
        @Expose
        var prefix: String? = null,
        @SerializedName("suffix")
        @Expose
        var suffix: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(prefix)
        parcel.writeString(suffix)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhotoTip> {
        override fun createFromParcel(parcel: Parcel): PhotoTip {
            return PhotoTip(parcel)
        }

        override fun newArray(size: Int): Array<PhotoTip?> {
            return arrayOfNulls(size)
        }
    }
}

class PhotoUser() : Parcelable {

    @SerializedName("prefix")
    @Expose
    var prefix: String? = null
    @SerializedName("suffix")
    @Expose
    var suffix: String? = null

    constructor(parcel: Parcel) : this() {
        prefix = parcel.readString()
        suffix = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(prefix)
        parcel.writeString(suffix)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhotoUser> {
        override fun createFromParcel(parcel: Parcel): PhotoUser {
            return PhotoUser(parcel)
        }

        override fun newArray(size: Int): Array<PhotoUser?> {
            return arrayOfNulls(size)
        }
    }
}

data class PlacesDataResponse(
        @SerializedName("groups")
        @Expose
        var groups: List<GroupVenues>? = null
)

data class Stats(
        @SerializedName("checkinsCount")
        @Expose
        var checkinsCount: Int? = null,
        @SerializedName("usersCount")
        @Expose
        var usersCount: Int? = null,
        @SerializedName("tipCount")
        @Expose
        var tipCount: Int? = null,
        @SerializedName("visitsCount")
        @Expose
        var visitCount: Int? = null
)

data class User(
        @SerializedName("id")
        @Expose
        var id: String? = null,
        @SerializedName("firstName")
        @Expose
        var firstName: String? = null,
        @SerializedName("lastName")
        @Expose
        var lastName: String? = null,
        @SerializedName("gender")
        @Expose
        var gender: String? = null,
        @SerializedName("photo")
        @Expose
        var photo: PhotoUser? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(PhotoUser::class.java.classLoader))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(gender)
        parcel.writeParcelable(photo, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
