package com.luyang.intelligentraffic.global;

import android.app.Activity;
import android.content.Context;

import com.luyang.intelligentraffic.objects.DigitalTrafficMessageSign;

/**
 * Created by Luyang on 9/23/15.
 */
public class Global {


    public static final String BROADCAST_GEO_ACTIVITY = "com.luyang.smartlogger.GEO_ACTIVITY_BROADCAST";
    public static final String BROADCAST_GOOGLE_ACTIVITY = "com.luyang.smartlogger.GOOGLE_ACTIVITY_BROADCAST";
    public static final String BROADCAST_ACCELERATION ="com.luyang.smartlogger.ACCELERATION_BROADCAST";
    public static final String BROADCAST_GYROSCOPE = "com.luyang.smartlogger.GYROSCOPE_BROADCAST";
    public static final String BROADCAST_MAGNETO = "com.luyang.smartlogger.MAGNETO_BROADCAST";
    public static final String BROADCAST_ROTATION_VECTOR = "com.luyang.smartlogger.ROTATION_VECTOR_BROADCAST";
    public static final String BROADCAST_QUATERNION = "com.luyang.smartlogger.QUATERNION_BROADCAST";
    public static final String BROADCAST_ROTATION_MATRIX = "com.luyang.smartlogger.ROTATION_MATRIX_BROADCAST";
    public static final String BROADCAST_LOCATION = "com.luyang.smartlogger.LOCATION_BROADCAST";
    public static final String BROADCAST_UNIVERSAL_TIMER = "com.luyang.smartlogger.UNIVERSAL_TIMER_BROADCAST";;
    public static final String BROADCAST_DEBUG_TIMER ="com.luyang.smartlogger.TIMER_DEBUG_BROADCAST";
    public static final String BROADCAST_BLUETOOTH_ACTIVITY ="com.luyang.smartlogger.BLUETOOTH_ACTIVITY_BROADCAST";
    public static final String BROADCAST_WIFI_ACTIVITY ="com.luyang.smartlogger.WIFI_ACTIVITY_BROADCAST";
    public static final String BROADCAST_PHONE_SENSOR ="com.luyang.smartlogger.BROADCAST_PHONE_SENSOR";
    public static final String BROADCAST_IMU_SENSOR ="com.luyang.smartlogger.BROADCAST_IMU_SENSOR";

    public static final String BROADCAST_CONTROL_ENVIRONMENT ="com.luyang.smartlogger.CONTROL_ENVIRONMENT_BROADCAST";
    public static final String CONTROL_ENVIRONMENT_CODE ="com.luyang.smartlogger.ENVIRONMENT_CONTROL_CODE";

    public static final String EXTENDED_DATA_GOOGLE_ACTIVITY_MESSAGE = "com.luyang.smartlogger.GOOGLE_ACTIVITY_MESSAGE";
    public static final String EXTENDED_DATA_GOOGLE_ACTIVITY_CODE = "com.luyang.smartlogger.GOOGLE_ACTIVITY_CODE";
    public static final String EXTENDED_DATA_GOOGLE_ACTIVITY_CONFIDENCE = "com.luyang.smartlogger.GOOGLE_ACTIVITY_CONFIDENCE";
    public static final String EXTENDED_DATA_GEO_ACTIVITY_MESSAGE = "com.luyang.smartlogger.GEO_ACTIVITY_MESSAGE";
    public static final String EXTENDED_DATA_GEO_ACTIVITY_CODE = "com.luyang.smartlogger.GEO_ACTIVITY_CODE";
    public static final String EXTENDED_DATA_GEO_ACTIVITY_CONFIDENCE = "com.luyang.smartlogger.GEO_ACTIVITY_CONFIDENCE";
    public static final String EXTENDED_DATA_GEO_SPEED = "com.luyang.smartlogger.GEO_SPEED";
    public static final String EXTENDED_DATA_ACCELX = "com.luyang.smartlogger.ACCELX";
    public static final String EXTENDED_DATA_ACCELY = "com.luyang.smartlogger.ACCELY";
    public static final String EXTENDED_DATA_ACCELZ = "com.luyang.smartlogger.ACCELZ";
    public static final String EXTENDED_DATA_GYROX = "com.luyang.smartlogger.GYROX";
    public static final String EXTENDED_DATA_GYROY = "com.luyang.smartlogger.GYROY";
    public static final String EXTENDED_DATA_GYROZ = "com.luyang.smartlogger.GYROZ";
    public static final String EXTENDED_DATA_MAGNETOX = "com.luyang.smartlogger.MAGNETOX";
    public static final String EXTENDED_DATA_MAGNETOY = "com.luyang.smartlogger.MAGNETOY";
    public static final String EXTENDED_DATA_MAGNETOZ = "com.luyang.smartlogger.MAGNETOZ";
    public static final String EXTENDED_DATA_ROTX = "com.luyang.smartlogger.ROTX";
    public static final String EXTENDED_DATA_ROTY = "com.luyang.smartlogger.ROTY";
    public static final String EXTENDED_DATA_ROTZ = "com.luyang.smartlogger.ROTZ";
    public static final String EXTENDED_DATA_QUATW = "com.luyang.smartlogger.QUATW";
    public static final String EXTENDED_DATA_QUATX = "com.luyang.smartlogger.QUATX";
    public static final String EXTENDED_DATA_QUATY = "com.luyang.smartlogger.QUATY";
    public static final String EXTENDED_DATA_QUATZ = "com.luyang.smartlogger.QUATZ";
    public static final String EXTENDED_DATA_LAT = "com.luyang.smartlogger.LAT";
    public static final String EXTENDED_DATA_LNG = "com.luyang.smartlogger.LNG";
    public static final String EXTENDED_DATA_TIMETAG = "com.luyang.smartlogger.TIMETAG";
    public static final String EXTENDED_DATA_DEBUG_TIMER ="com.luyang.smartlogger.TIMER_DEBUG";
    public static final String EXTENDED_DATA_NETWORK_ACTIVITY_CODE = "com.luyang.smartlogger.NETWORK_ACTIVITY_CODE";
    public static final String EXTENDED_BLUETOOTH_ACTIVITY_STATUS = "com.luyang.smartlogger.BLUETOOTH_ACTIVITY_STATUS";
    public static final String EXTENDED_BLUETOOTH_DEVICE_NAME = "com.luyang.smartlogger.BLUETOOTH_DEVICE_NAME";
    public static final String EXTENDED_BLUETOOTH_DEVICE_ADDRESS = "com.luyang.smartlogger.BLUETOOTH_DEVICE_ADDRESS";
    public static final String EXTENDED_WIFI_STATUS = "com.luyang.smartlogger.WIFI_STATUS";
    public static final String EXTENDED_WIFI_SSID = "com.luyang.smartlogger.WIFI_SSID";
    public static final String EXTENDED_WIFI_RSSI = "com.luyang.smartlogger.WIFI_RSSI";
    public static final String EXTENDED_PHONE_SENSOR_VALUE = "com.luyang.smartlogger.EXTENDED_PHONE_SENSOR_VALUE";
    public static final String EXTENDED_PHONE_SENSOR_TYPE = "com.luyang.smartlogger.EXTENDED_PHONE_SENSOR_TYPE";
    public static final String EXTENDED_IMU_SENSOR_VALUE = "com.luyang.smartlogger.EXTENDED_IMU_SENSOR_VALUE";
    public static final String EXTENDED_IMU_SENSOR_TYPE = "com.luyang.smartlogger.EXTENDED_IMU_SENSOR_TYPE";

    public static final String EXTENDED_LOG_ACCELERATION = "A";
    public static final String EXTENDED_LOG_GYROSCOPE = "G";
    public static final String EXTENDED_LOG_MAGNETO = "M";
    public static final String EXTENDED_LOG_GOOGLE_ACTIVITY= "GACT";
    public static final String EXTENDED_LOG_LOCATION = "L";
    public static final String EXTENDED_LOG_GEO_ACTIVITY = "GEOACT";
    public static final int REQUEST_RESOLVE_ERROR = 1001;

    public static final int ACTIVITY_TYPE_INDOORS_ACTIVE = 0;
    public static final int ACTIVITY_TYPE_STATIC = 1;
    public static final int ACTIVITY_TYPE_WALKING = 2;
    public static final int ACTIVITY_TYPE_DRIVING = 3;
    public static final int ACTIVITY_TYPE_UNKNOWN = 4;

    // Direction Type for DigitalTrafficMessageSign Class
    public final static int Direction_Type_North = 1;
    public final static int Direction_Type_South = 2;
    public final static int Direction_Type_West = 3;
    public final static int Direction_Type_East = 4;

    public static Context environmentContext = null;
    public static Activity environmentActivity = null;

    public static DigitalTrafficMessageSign dummyDTMS = new DigitalTrafficMessageSign();
}
