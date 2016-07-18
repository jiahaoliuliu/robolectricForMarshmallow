package com.jiahaoliuliu.robolectricformarshmallow.controller;

import android.content.Context;
import com.jiahaoliuliu.robolectricformarshmallow.R;

/**
 * Created by Jiahao on 7/18/16.
 */
public class MainController {

    private Context mContext;

    public MainController(Context context) {
        this.mContext = context;
    }

    public String getTextToDisplay(boolean permissionGranted) {
        if (permissionGranted) {
            return mContext.getResources().getString(R.string.permission_granted);
        } else {
            return mContext.getResources().getString(R.string.permission_denied);
        }
    }
}
