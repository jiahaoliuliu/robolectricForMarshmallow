package com.jiahaoliuliu.robolectricformarshmallow;

import com.jiahaoliuliu.robolectricformarshmallow.shadow.MainControllerShadow;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by jiahao on 19/09/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, manifest = Config.NONE, application = FoolApplication.class
        , shadows = {MainControllerShadow.class}
        )
public class BaseTest {
}
