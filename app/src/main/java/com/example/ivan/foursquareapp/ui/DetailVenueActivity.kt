package com.example.ivan.foursquareapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.ivan.foursquareapp.GlideApp
import com.example.ivan.foursquareapp.R
import com.example.ivan.foursquareapp.models.DetailnfoVenue
import kotlinx.android.synthetic.main.activity_detail_venue.*


class DetailVenueActivity : AppCompatActivity() {

    private var mAdapter: RecyclerAdapterTips? = null
    private var mManager: LinearLayoutManager? = null
    private var mVenue: DetailnfoVenue? = null

    companion object {
        private const val VENUE = "venue"

        fun start(context: Context, venue: DetailnfoVenue) {
            val starter = Intent(context, DetailVenueActivity::class.java)
            starter.putExtra(VENUE, venue)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_venue)
        mVenue = intent.getParcelableExtra(VENUE)
        initUi(mVenue!!)
    }

    private fun initUi(venue: DetailnfoVenue) {
        mAdapter = RecyclerAdapterTips(venue.tips)
        mManager = LinearLayoutManager(this)
        recyclerViewTips.layoutManager = mManager
        recyclerViewTips.adapter = mAdapter
    }


}