package com.luyang.intelligentraffic.objects;

import android.location.Location;

/**
 * Created by Luyang on 9/24/15.
 */
public class DigitalTrafficMessageSign {


    private final static int Direction_Type_North = 1;
    private final static int Direction_Type_South = 2;
    private final static int Direction_Type_West = 3;
    private final static int Direction_Type_East = 4;

    private double lat;
    private double lng;
    private int directionType;

    public DigitalTrafficMessageSign(){

    }

    public DigitalTrafficMessageSign(double lat, double lng, int directionType) {
        this.lat = lat;
        this.lng = lng;
        this.directionType = directionType;
    }

    public DigitalTrafficMessageSign(Location location, int directionType) {
        this.lat = location.getLatitude();
        this.lng = location.getLongitude();
        this.directionType = directionType;
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lng;
    }

}
