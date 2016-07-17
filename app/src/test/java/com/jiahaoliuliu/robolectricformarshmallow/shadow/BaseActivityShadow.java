package com.jiahaoliuliu.robolectricformarshmallow.shadow;

import android.content.Context;
import com.jiahaoliuliu.robolectricformarshmallow.BaseActivity;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowActivity;

/**
 * Created by Jiahao on 7/17/16.
 */
@Implements(BaseActivity.class)
public class BaseActivityShadow extends ShadowActivity {

    @Implementation
    private Context getContext() {
        return RuntimeEnvironment.application;
    }
}
