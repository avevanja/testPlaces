package com.example.ivan.foursquareapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.ivan.foursquareapp.R
import com.example.ivan.foursquareapp.entity.DetailVenue
import com.example.ivan.foursquareapp.presentation.detailInfo.DetailInfoPresenter
import com.example.ivan.foursquareapp.presentation.detailInfo.DetailInfoView
import com.example.ivan.foursquareapp.ui.adapters.RecyclerAdapterTips
import com.example.ivan.foursquareapp.utils.GlideApp
import kotlinx.android.synthetic.main.activity_detail_venue.*


class DetailVenueActivity : MvpAppCompatActivity(), DetailInfoView {

    private var mAdapter: RecyclerAdapterTips? = null
    private var mManager: LinearLayoutManager? = null
    @InjectPresenter
    lateinit var mPresenter: DetailInfoPresenter

    companion object {
        private const val VENUE = "venue"

        fun start(context: Context, venueId: String) {
            val starter = Intent(context, DetailVenueActivity::class.java)
            starter.putExtra(VENUE, venueId)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_venue)
        mPresenter.getDetailInfo(intent.getStringExtra(VENUE))
    }

    private fun initUi(venue: DetailVenue) {
        mAdapter = RecyclerAdapterTips(venue.tips!!.groups!![0].items!!.take(3))
        mManager = LinearLayoutManager(this)
        recyclerViewTips.layoutManager = mManager
        recyclerViewTips.adapter = mAdapter
        with(venue.photos!!.groups!![0].items!![0]) {
            GlideApp
                    .with(imageViewLogo.context)
                    .load(prefix + "600x400" + suffix)
                    .centerCrop()
                    .into(imageViewLogo)
        }
        textViewLikes.text = venue.likes!!.count.toString()
        textViewRating.text = venue.rating.toString()
        textViewVisitors.text = venue.stats!!.visitsCount.toString()

    }

    override fun getDetailInfo(venue: DetailVenue) {
        initUi(venue)
    }

    override fun errorGetInfo(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}