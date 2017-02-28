package com.genosharing.gwyn;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by Corinna on 28.02.2017.
 */

public class GWYN extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }
}
