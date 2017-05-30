package com.luyang.intelligentraffic.service;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import com.luyang.intelligentraffic.global.Global;
import com.luyang.intelligentraffic.ui.EnvironmentHolder;

/**
 * Created by Cagdas on 4/15/2015.
 */
public class GoogleActivityDetector extends IntentService implements  GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    String tag = "GoogleActivity";
    private EnvironmentHolder holder;
    private GoogleApiClient mGoogleApiClient;
    private boolean mResolvingError = false;
    private PendingIntent callbackIntent;
    private boolean isConnected = false;

    public GoogleActivityDetector()
    { super("not important");
    }

    public GoogleActivityDetector(EnvironmentHolder holder)
    {super("not important");
        this.holder = holder;
        mGoogleApiClient = new GoogleApiClient.Builder(holder.context_)
                .addApi(ActivityRecognition.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        mGoogleApiClient.connect();

    }
    protected void onHandleIntent(Intent intent)
    {
      //  Toast.makeText(this, "onHandleintent", Toast.LENGTH_SHORT).activityRecognitionIntentServiceshow();
        if (ActivityRecognitionResult.hasResult(intent)) {
            ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent); // Put your application specific logic here (i.e. result.getMostProbableActivity())
            DetectedActivity detActivity = result.getMostProbableActivity();
            String msg = "";
            switch (detActivity.getType()){
                case DetectedActivity.ON_BICYCLE:
                    msg = "You are riding";
                    break;
                case DetectedActivity.ON_FOOT:
                    msg="You are on foot";
                    break;
                case DetectedActivity.IN_VEHICLE:
                    msg="You are in Vehicle";
                    break;
                case DetectedActivity.RUNNING:
                    msg="You are running";
                    break;
                case DetectedActivity.STILL:
                    msg="Phone is still";
                    break;
                case DetectedActivity.TILTING:
                    msg ="Phone is tilting";
                    break;
                case DetectedActivity.WALKING:
                    msg = "You are walking";
                    break;
                case DetectedActivity.UNKNOWN:
                    msg= "What are you doing?";
                    break;}

            Long tsLong = System.currentTimeMillis();
           Intent localIntent = new Intent(Global.BROADCAST_GOOGLE_ACTIVITY)
                    .putExtra(Global.EXTENDED_DATA_GOOGLE_ACTIVITY_MESSAGE, msg)
                    .putExtra(Global.EXTENDED_DATA_GOOGLE_ACTIVITY_CODE, detActivity.getType())
                    .putExtra(Global.EXTENDED_DATA_GOOGLE_ACTIVITY_CONFIDENCE, detActivity.getConfidence())
                    .putExtra(Global.EXTENDED_DATA_TIMETAG,tsLong);

            LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
            Log.i(tag, "activity published");


        }
    }

    public void stopService()
    {
        if(isConnected)
            ActivityRecognition.ActivityRecognitionApi.removeActivityUpdates(mGoogleApiClient, callbackIntent);
        mGoogleApiClient.disconnect();
        Log.i(tag, "Service stopped");
    }


    @Override
    public void onConnected(Bundle bundle) {
        Log.i(tag, "Successfully connected to play services!");
        Intent intent = new Intent(holder.context_,GoogleActivityDetector.class);

        callbackIntent = PendingIntent.getService(holder.context_, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates(mGoogleApiClient, 0, callbackIntent);
        isConnected = true;




    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(tag, "play services connection SUSPENDED!");
    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(tag, "connection to play services FAILED!");
        if(mResolvingError)
            return;
        else if(connectionResult.hasResolution()) {
            Log.i(tag, "and it has resolution!");
            mResolvingError = true;
            try {
                connectionResult.startResolutionForResult(holder.context_, Global.REQUEST_RESOLVE_ERROR);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }


        }else{
            Toast.makeText(holder.context_, "This program is fucked up!", Toast.LENGTH_LONG).show();
            mResolvingError = true;
            Log.i(tag, "no!");
        }
    }

}