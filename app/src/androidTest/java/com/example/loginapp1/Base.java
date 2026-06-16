package com.example.loginapp1;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class Base {


    protected static UiDevice device;
    private static Context context;
    protected static String packageName;
    private static final String className = Base.class.getSimpleName();
    protected static MainPage mMainPage;

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            System.out.println("Starting: " + description.getMethodName());
        }

        @Override
        protected void succeeded(Description description) {
            System.out.println("Passed: " + description.getMethodName());
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("Failed: " + description.getMethodName());
            e.printStackTrace();
        }
    };

    public static void setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        context = InstrumentationRegistry.getInstrumentation().getContext();
        packageName = getApplicationContext().getPackageName();
//        mMainPage = new MainPage();
        Log.d("KefeiLog " + className, packageName);
    }

    public void pressHomeKey() {
        device.pressHome();
    }

    public void pressBackKey() {
        device.pressBack();
    }

    public void launchApp() {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
            device.waitForIdle();
        }
        SystemClock.sleep(2000);
        Log.d("KefeiLog " + className, "launchApp");
    }

//    public void verifyNextButton() {
//        Log.d("KefeiLog " + className, "verifyNextButton");
//        nextButton = device.findObject(By.res("com.example.loginapp1:id/buttonNext"));
//        String buttonText = nextButton.getText();
//        Log.d("KefeiLog " + className, buttonText);
//        assertEquals("Verify Next button text", "Next", buttonText);
//    }
//
//
//    public void verifyToastButton() {
//        Log.d("KefeiLog " + className, "verifyNexToastButton");
//        toastButton = device.findObject(By.res(packageName + ":id/buttonToast"));
//        String buttonText = toastButton.getText();
//        Log.d("KefeiLog " + className, buttonText);
//        assertEquals("Verify Toast button text", "Toast", buttonText);
//    }

}
