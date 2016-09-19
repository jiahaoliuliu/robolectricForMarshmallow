package com.jiahaoliuliu.robolectricformarshmallow.controller;

import android.content.Context;
import com.jiahaoliuliu.robolectricformarshmallow.R;

/**
 * Created by Jiahao on 7/18/16.
 */
public class MainController {

    private Context mContext;

    private static MainController mainController;

    public MainController(Context context) {
        this.mContext = context;
    }

    public static synchronized MainController getMainController(Context context) {
        if (mainController == null) {
            mainController = new MainController(context);
        }
        return mainController;
    }

    public String getTextToDisplay(boolean permissionGranted) {
        if (permissionGranted) {
            return mContext.getResources().getString(R.string.permission_granted);
        } else {
            return mContext.getResources().getString(R.string.permission_denied);
        }
    }

    public String getWaitingPermissionText() {
        return mContext.getResources().getString(R.string.waiting_for_permission);
    }
}
