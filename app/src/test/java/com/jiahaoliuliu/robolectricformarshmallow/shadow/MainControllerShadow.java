package com.jiahaoliuliu.robolectricformarshmallow.shadow;

import com.jiahaoliuliu.robolectricformarshmallow.controller.MainController;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

/**
 * Created by Jiahao on 7/18/16.
 */
@Implements(MainController.class)
public class MainControllerShadow {

    @Implementation
    public String getTextToDisplay(boolean permissionGranted) {
        return "Test";
    }
}
