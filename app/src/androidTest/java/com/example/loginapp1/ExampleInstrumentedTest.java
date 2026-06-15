package com.example.loginapp1;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExampleInstrumentedTest extends Base{
//    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.example.loginapp1", appContext.getPackageName());
//    }


    private final MainPage mMainPage = new MainPage();

    @BeforeClass
    public static void setUp() {
        Base.setUp();
    }

    @AfterClass
    public static void tearDown() {
        device.pressHome();
    }


    @Test
    public void test_001_verifyNextButton() {
        launchApp();
        mMainPage.verifyNextButton();
        SystemClock.sleep(2000);
        pressHomeKey();
    }


    @Test
    public void test_002_verifyToastButton() {
        launchApp();
        mMainPage.verifyToastButton();
        SystemClock.sleep(2000);
        pressHomeKey();
    }


    @Test
    public void test_003_verifyMessage() {
        launchApp();
        mMainPage.verifyMessage();
        SystemClock.sleep(2000);
        pressHomeKey();
    }

//    @Test
//    public void pressHomeKey() {
//
//        device.pressHome();
//    }
}