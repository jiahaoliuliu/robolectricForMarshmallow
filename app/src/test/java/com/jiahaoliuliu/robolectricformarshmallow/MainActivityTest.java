package com.jiahaoliuliu.robolectricformarshmallow;

import com.jiahaoliuliu.robolectricformarshmallow.shadow.MainControllerShadow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by Jiahao on 6/30/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, manifest = Config.NONE, application = FoolApplication.class,
    shadows = { MainControllerShadow.class}, sdk = 18)
public class MainActivityTest {

    private MainActivity mMainActivity;

    @Before
    public void setUp() throws Exception {
        mMainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testOnCreate() throws Exception {
        // Simple test to know that it works
        assertTrue(true);
    }
}