package com.luyang.intelligentraffic.ui;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.luyang.intelligentraffic.global.Global;

import java.util.List;

/**
 * Created by Cagdas on 4/16/2015.
 */
public class LocationReceiver implements LocationListener {
    private final String locationProvider = "LocationReceiver";

    private String tag = "LocationReceiver";
    private EnvironmentHolder holder;

    private LocationManager mLocation;

    public LocationReceiver(EnvironmentHolder holder){
        this.holder = holder;
        //PLAY ACTIVITY


        mLocation= (LocationManager) holder.context_.getSystemService(Context.LOCATION_SERVICE);
        List<String> lProviders = mLocation.getAllProviders();
        Log.i(tag, "Providers");
        for (String lProvider : lProviders) {
            Log.i(tag, lProvider);
        }
        mLocation.getLastKnownLocation(locationProvider);
        mLocation.requestLocationUpdates(locationProvider,6000,0,this);

    }
    
    @Override
    public void onLocationChanged(Location location) {
       
        Log.i(tag, "location changed");
        Long tsLong = System.currentTimeMillis();
        Intent intent = new Intent(Global.BROADCAST_LOCATION)
                .putExtra(Global.EXTENDED_DATA_LAT, location.getLatitude())
                .putExtra(Global.EXTENDED_DATA_LNG, location.getLongitude())
                .putExtra(Global.EXTENDED_DATA_TIMETAG,tsLong);


        LocalBroadcastManager.getInstance(holder.context_).sendBroadcast(intent);


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.i(tag, "stat changed");
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }




    public void setUpdateInterval(int minTime) {
        mLocation.removeUpdates(this);
        mLocation.requestLocationUpdates(locationProvider,minTime*1000,0,this);

    }
}
