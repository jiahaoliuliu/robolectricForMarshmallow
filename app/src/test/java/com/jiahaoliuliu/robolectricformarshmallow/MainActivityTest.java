package com.jiahaoliuliu.robolectricformarshmallow;

import com.jiahaoliuliu.robolectricformarshmallow.shadow.SettingsShadow;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by Jiahao on 6/30/16.
 */
@Config(shadows = {SettingsShadow.class})
public class MainActivityTest extends BaseTest<MainActivity>{
    private MainActivity mMainActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        // Getting the activity.
        mMainActivity = getActivity();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testOnCreate() throws Exception {
        // Simple test to know that it works
        assertTrue(true);

        // The debug is always set in the shadows
        String actionBarTitle = mMainActivity.getSupportActionBar().getTitle().toString();
        assertEquals(actionBarTitle, mMainActivity.getResources().getString(R.string.app_name_debugging));
    }
}