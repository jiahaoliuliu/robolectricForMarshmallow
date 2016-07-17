package com.jiahaoliuliu.robolectricformarshmallow;

import android.content.Context;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;

/**
 * Created by Jiahao on 7/14/16.
 */
public class FoolApplication extends MainApplication {

    public static Context getContext() {
        return RuntimeEnvironment.application;
    }

    @Override
    public Context getApplicationContext() {
        return RuntimeEnvironment.application;
    }
}
