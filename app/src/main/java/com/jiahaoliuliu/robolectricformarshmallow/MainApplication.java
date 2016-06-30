package com.jiahaoliuliu.robolectricformarshmallow;

import android.app.Application;
import android.content.Context;

/**
 * Created by Jiahao on 6/30/16.
 */
public class MainApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.sContext = getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }
}
