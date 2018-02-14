package com.example.ivan.foursquareapp.data

import com.example.ivan.foursquareapp.models.DetailInfoResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class DetailInfoRepository {

    fun getDetailInfo(idVenue: String, params: Map<String, String>): Single<DetailInfoResponse> {

        return RetrofitBuilder.foursquareApiWithRx.getDetailInfo(idVenue, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}