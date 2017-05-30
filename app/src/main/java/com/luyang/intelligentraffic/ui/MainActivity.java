package com.luyang.intelligentraffic.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.luyang.intelligentraffic.R;
import com.luyang.intelligentraffic.global.Global;

/**
 * Created by Luyang on 9/22/2015.
 */
public class MainActivity extends ActionBarActivity {

    EnvironmentHolder mEnvironmentHolder;
    private static Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Global.environmentContext = getApplicationContext();
        Global.environmentActivity = this;

        //Start the Environment Holder
        mEnvironmentHolder = new EnvironmentHolder(this);
        mThread = new Thread(mEnvironmentHolder);
        mThread.start();

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            GoogleMapFragment firstFragment = new GoogleMapFragment();
            firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
