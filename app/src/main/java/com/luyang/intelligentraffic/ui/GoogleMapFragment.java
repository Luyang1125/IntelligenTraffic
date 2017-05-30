package com.luyang.intelligentraffic.ui;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.luyang.intelligentraffic.R;
import com.luyang.intelligentraffic.global.Global;

/**
 * Created by Luyang on 9/22/2015.
 */
public class GoogleMapFragment extends Fragment {

    private static final String TAG = "IT_GPS";

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private LocationManager locationManager;
    private String provider;

    public GoogleMapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_googlemap, container, false);
        setUpMapIfNeeded();
        //GoogleActivityDetector mGoogleActivityDetector = new GoogleActivityDetector();
        return view;
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.

        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.

            mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)) .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
                setLocationUpdate();
            }
        }
    }

    private void setUpMap() {
        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.setMyLocationEnabled(true);

    }

    private void setLocationUpdate() {
        Log.i(TAG, "Location Update begin");
        locationManager = (LocationManager) Global.environmentContext.getSystemService(Context.LOCATION_SERVICE);
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            throw new RuntimeException("GPS is not enabled.\n" +
                    "Activate GPS");
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        provider = LocationManager.GPS_PROVIDER;
        provider = locationManager.getBestProvider(criteria, true);

        locationManager.requestLocationUpdates(provider, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i(TAG, "LastKnown: " + provider + " " + location.getLatitude() + " " + location.getLongitude());
                mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(12));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });

        Location currentLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        Location currentLocationNetwork = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if(currentLocation != null || currentLocationNetwork!=null) {
            if (currentLocation == null)
                currentLocation = currentLocationNetwork;
            Log.e(TAG, "LastKnown: " + provider + " " + currentLocation.getLatitude() + " " + currentLocation.getLongitude());
            mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude())));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(12));
        }

    }


}
