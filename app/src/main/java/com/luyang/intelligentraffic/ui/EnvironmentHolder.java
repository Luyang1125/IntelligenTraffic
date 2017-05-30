package com.luyang.intelligentraffic.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;

import com.luyang.intelligentraffic.global.Global;
import com.luyang.intelligentraffic.service.GoogleActivityDetector;

import java.util.Timer;


/**
 * Created by Cagdas on 4/21/2015.
 * EnvironmentHolder holds all the sensors and sender's also acts like a backbone for main thread
 */
public class EnvironmentHolder implements Runnable {
    String tag = "EnvironmentHolder";
//    private Looper mLoop;
    private GoogleActivityDetector mGoogleActivityDetector;
    public LocationReceiver mLocationReceiver;
    public Activity context_;

    public EnvironmentHolder(Activity c){
        this.context_ = c;

    }


    @Override
    public void run() {
        Looper.prepare();

        //mLocationReceiver = new LocationReceiver(this);
        GoogleActivityDetector mGoogleActivityDetector = new GoogleActivityDetector(this);

        while(!Thread.interrupted() ){
            try {
                Thread.sleep(1000);
                Intent localintent = new Intent(Global.BROADCAST_UNIVERSAL_TIMER);
                LocalBroadcastManager.getInstance(context_).sendBroadcast(localintent);
//                Log.d(tag," I AM STILL WORKING");
            } catch (InterruptedException e) {
                mGoogleActivityDetector.stopService();
                return;
            }

        }
//        task.cancel();


    }


//    TimerTask task = new TimerTask(){
//
//        public void run()
//        {
//
//
//        }
//
//    };




}
