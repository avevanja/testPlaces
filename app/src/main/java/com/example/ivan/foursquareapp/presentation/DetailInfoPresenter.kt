package com.example.ivan.foursquareapp.presentation


import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.ivan.foursquareapp.Constants
import com.example.ivan.foursquareapp.PlacesApplication
import com.example.ivan.foursquareapp.data.DetailInfoRepository
import com.example.ivan.foursquareapp.models.DetailInfoResponse
import io.reactivex.observers.DisposableSingleObserver
import java.util.*
import javax.inject.Inject

@InjectViewState
class DetailInfoPresenter : MvpPresenter<DetailInfoView>() {

    @Inject
    lateinit var mRepository: DetailInfoRepository

    init {
        PlacesApplication.graph.inject(this)
    }


    fun getDetailInfo(id: String) {

        val parameters = HashMap<String, String>()
        parameters["client_id"] = Constants.CLIENT_ID
        parameters["client_secret"] = Constants.CLIENT_SECRET
        parameters["v"] = "20170213"
        mRepository.getDetailInfo(id, parameters)
                .subscribeWith(object : DisposableSingleObserver<DetailInfoResponse>() {
                    override fun onSuccess(detailInfoResponse: DetailInfoResponse) {
                        viewState.getDetailInfo(detailInfoResponse.response!!.venue!!)
                    }

                    override fun onError(e: Throwable) {
                        viewState.errorGetInfo(e.localizedMessage)
                    }
                })
    }
}
