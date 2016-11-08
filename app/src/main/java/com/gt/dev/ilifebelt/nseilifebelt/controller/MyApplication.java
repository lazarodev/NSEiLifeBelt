package com.gt.dev.ilifebelt.nseilifebelt.controller;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Community on 26/10/16.
 */

public class MyApplication extends com.activeandroid.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Initialization active android
        ActiveAndroid.initialize(this);
        //ActiveAndroid.dispose();
    }
}
