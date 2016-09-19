package com.jiahaoliuliu.robolectricformarshmallow.shadow;

import com.jiahaoliuliu.robolectricformarshmallow.model.Settings;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

/**
 * Created by jiahao on 19/09/16.
 */
@Implements(Settings.class)
public class SettingsShadow {

    @Implementation
    public boolean isDebugging() {
        return true;
    }
}
