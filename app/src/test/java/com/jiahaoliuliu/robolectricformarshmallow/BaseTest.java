package com.jiahaoliuliu.robolectricformarshmallow;

import android.app.Activity;

import com.jiahaoliuliu.robolectricformarshmallow.shadow.MainControllerShadow;

import org.junit.After;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

/**
 * Created by jiahao on 19/09/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, manifest = Config.NONE, application = FoolApplication.class
        , shadows = {MainControllerShadow.class}
        )
public class BaseTest <T extends Activity>{

    private Class mClazz;
    private ActivityController<T> mActivityController;

    public BaseTest(Class<T> clazz) {
        this.mClazz = clazz;
    }

    /**
     * Get the activity. This method is not set inside the constructor but outside
     * allow the tests control better when the activities will be set.
     * @return
     *      The activity already visible
     */
    protected T getActivity() {
        this.mActivityController =
                Robolectric.buildActivity(mClazz).create().start().postCreate(null).resume().visible();
        return mActivityController.get();
    }

    @After
    public void tearDown() throws Exception{
        if (mActivityController != null) {
            mActivityController.pause().stop().destroy();
        }
    }
}
