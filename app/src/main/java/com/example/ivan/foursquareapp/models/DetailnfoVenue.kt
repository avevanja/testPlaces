package com.example.ivan.foursquareapp.models

import android.os.Parcel
import android.os.Parcelable


data class DetailnfoVenue(val visitCount: Int, val rating: Double, val photo: String?, val tips: List<Tip>) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.createTypedArrayList(Tip))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(visitCount)
        parcel.writeDouble(rating)
        parcel.writeString(photo)
        parcel.writeTypedList(tips)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DetailnfoVenue> {
        override fun createFromParcel(parcel: Parcel): DetailnfoVenue {
            return DetailnfoVenue(parcel)
        }

        override fun newArray(size: Int): Array<DetailnfoVenue?> {
            return arrayOfNulls(size)
        }
    }
}
