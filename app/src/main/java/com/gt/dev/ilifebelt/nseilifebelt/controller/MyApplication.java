package com.gt.dev.ilifebelt.nseilifebelt.controller;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Community on 26/10/16.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Initialization active android
        ActiveAndroid.initialize(this);
    }
}
