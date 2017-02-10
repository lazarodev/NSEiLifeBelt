package com.gt.dev.ilifebelt.nseilifebelt.controller;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.gt.dev.ilifebelt.nseilifebelt.utility.Parameters;

/**
 * Created by Community on 26/10/16.
 */

public class MyApplication extends Application {

    public Tracker mTracker;
    public GoogleAnalytics analytics;
    public String keyTracker;

    synchronized public Tracker getDefaultTracker() {

        if (mTracker == null) {
            analytics = GoogleAnalytics.getInstance(this);
            analytics.setLocalDispatchPeriod(1800);

            // Tracker starts
            keyTracker = Parameters.TRACKER_ANALYTICS;
            mTracker = analytics.newTracker(keyTracker);
            mTracker.enableAdvertisingIdCollection(true);
            mTracker.enableAutoActivityTracking(true);
            mTracker.enableExceptionReporting(true);
        }

        return mTracker;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Initialization active android
        ActiveAndroid.initialize(this);
        //ActiveAndroid.dispose();
    }
}
