package com.example.ivan.foursquareapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.ivan.foursquareapp.models.PlacesResponse;
import com.example.ivan.foursquareapp.models.RecyclerAdapterPlaces;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class PlacesActivity extends MvpAppCompatActivity implements RecyclerAdapterPlaces.ItemClick {

    private RecyclerView mRecyclerViewPlaces;
    private LinearLayoutManager mManger;
    private RecyclerAdapterPlaces mAdapter;
    private static final int REQUEST_CALL = 1113;
    private Intent mCallIntent;


    public static void start(Context context) {
        Intent starter = new Intent(context, PlacesActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        initRecyclerView();
        getPlaces();
    }

    private void getPlaces() {

    }

    private void initRecyclerView() {
        mRecyclerViewPlaces = findViewById(R.id.rv_places);
        mAdapter = new RecyclerAdapterPlaces(this);
        mManger = new LinearLayoutManager(this);
        mRecyclerViewPlaces.setLayoutManager(mManger);
        mRecyclerViewPlaces.setAdapter(mAdapter);
    }

    private boolean checkCallPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                this.requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }


    @Override
    public void itemClick() {

    }

    @Override
    public void phoneClick(String phone) {
        mCallIntent = new Intent(Intent.ACTION_CALL);
        mCallIntent.setData(Uri.parse("tel:" + phone));
        if (checkCallPermission())
            startActivity(mCallIntent);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (grantResults.length == 0) {
            return;
        }
        switch (requestCode) {
            case REQUEST_CALL:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(mCallIntent);
                }
                break;
        }
    }
}
