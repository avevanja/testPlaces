package com.example.ivan.foursquareapp.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.ivan.foursquareapp.R
import com.example.ivan.foursquareapp.entity.ItemVenue
import com.example.ivan.foursquareapp.presentation.places.PlacesPresenter
import com.example.ivan.foursquareapp.presentation.places.PlacesView
import com.example.ivan.foursquareapp.ui.adapters.RecyclerAdapterPlaces
import com.example.ivan.foursquareapp.utils.setIsLogin
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_places.*


class PlacesActivity : MvpAppCompatActivity(), RecyclerAdapterPlaces.ItemClick, PlacesView {

    @InjectPresenter
    lateinit var mPresenter: PlacesPresenter
    private var mRecyclerViewPlaces: RecyclerView? = null
    private var mManger: LinearLayoutManager? = null
    private var mAdapter: RecyclerAdapterPlaces? = null
    private var mCallIntent: Intent? = null
    private var mFusedLocationClient: FusedLocationProviderClient? = null

    companion object {
        private const val REQUEST_CALL = 1113
        private const val MY_PERMISSIONS_REQUEST_FINE_LOCATION = 1112


        fun start(context: Context) {
            val starter = Intent(context, PlacesActivity::class.java)
            context.startActivity(starter)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places)
        setSupportActionBar(toolbar)
        initRecyclerView()
        getCurrentLocation()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        return if (id == R.id.action_logout) {
            logOut()
            true
        } else super.onOptionsItemSelected(item)
    }

    private fun logOut() {
        LoginActivity.start(this)
        setIsLogin(false)
        finish()
    }

    private fun getCurrentLocation() {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        if (checkLocationPermission()) {
            mFusedLocationClient!!.lastLocation
                    .addOnSuccessListener(this, { location ->
                        if (location != null) {
                            mPresenter.getPlaces(location.latitude, location.longitude)
                        } else {
                            progressBar.visibility = View.GONE
                            Toast.makeText(this, "Please, turn on GPS", Toast.LENGTH_SHORT).show()
                        }
                    })
        }
    }


    private fun initRecyclerView() {
        mRecyclerViewPlaces = findViewById(R.id.rv_places)
        mAdapter = RecyclerAdapterPlaces(this)
        mManger = LinearLayoutManager(this)
        mRecyclerViewPlaces!!.layoutManager = mManger
        mRecyclerViewPlaces!!.adapter = mAdapter
    }

    private fun checkCallPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                this.requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CALL)
                false
            } else {
                true
            }
        } else {
            true
        }
    }

    private fun checkLocationPermission(): Boolean {
        return if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        MY_PERMISSIONS_REQUEST_FINE_LOCATION)
                false
            } else {
                true
            }
        } else {
            true
        }
    }


    override fun itemClick(venueId: String) {
        DetailVenueActivity.start(this, venueId)
    }

    override fun phoneClick(phone: String) {
        mCallIntent = Intent(Intent.ACTION_CALL)
        mCallIntent!!.data = Uri.parse("tel:" + phone)
        if (checkCallPermission())
            startActivity(mCallIntent)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (grantResults.isEmpty()) {
            return
        }
        when (requestCode) {
            REQUEST_CALL -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivity(mCallIntent)
            }
            MY_PERMISSIONS_REQUEST_FINE_LOCATION -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation()
            } else{
                progressBar.visibility = View.GONE
            }
        }
    }


    override fun getPlaces(list: List<ItemVenue>) {
        mAdapter!!.addVenues(list)
        progressBar.visibility = View.GONE
    }

    override fun errorGetPlaces(message: String) {
        progressBar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
