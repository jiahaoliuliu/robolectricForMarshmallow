package com.jiahaoliuliu.robolectricformarshmallow.shadow;

import android.content.Context;
import com.jiahaoliuliu.robolectricformarshmallow.controller.MainController;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

/**
 * Created by Jiahao on 7/18/16.
 */
@Implements(MainController.class)
public class MainControllerShadow {

    public void __constructor__ (Context context) {
        // Not do anything
    }

    @Implementation
    public String getTextToDisplay(boolean permissionGranted) {
        return "Test";
    }
}
