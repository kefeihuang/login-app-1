package com.example.loginapp1;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import static org.junit.Assert.assertEquals;

import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

public class MainPage extends Base{

    private final String className;
    protected UiObject2 textField;
    protected UiObject2 nextButton;
    protected UiObject2 toastButton;
    private static final String TAG = "KEFEI " + MainPage.class.getSimpleName();

    MainPage() {
        className = getClass().getSimpleName();
//        textField = device.findObject(By.res("com.example.loginapp1:id/textView"));
////        textField = device.findObject(By.res(packageName + ":id/textView"));
////    UiObject2 nextButton = device.findObject(By.res(packageName + ":id/buttonNext").text("Next"));
//        nextButton= device.findObject(By.res(packageName + "com.example.loginapp1:id/buttonNext"));
//        toastButton = device.findObject(By.res(packageName + "com.example.loginapp1:id/buttonToast"));
    }

    public void verifyNextButton() {
        Log.d("KefeiLog " + className, "verifyNextButton");
        System.out.println("verifyNextButton");
        nextButton = device.findObject(By.res("com.example.loginapp1:id/buttonNext"));
        String buttonText = nextButton.getText();
        Log.d("KefeiLog " + className, buttonText);
        assertEquals("Verify Next button text", "Next", buttonText);
    }

    public void verifyToastButton() {
        Log.d("KefeiLog " + className, "verifyNexToastButton");
        toastButton = device.findObject(By.res(packageName + ":id/buttonToast"));
        String buttonText = toastButton.getText();
        Log.d("KefeiLog " + className, buttonText);
        assertEquals("Verify Toast button text", "Toast", buttonText);
    }

    public void verifyMessage() {
        Log.d("KefeiLog " + className, "verifyMessage");
        textField = device.findObject(By.res(packageName + ":id/textView"));
        String message = textField.getText();
        Log.d("KefeiLog " + className, "verifyMessage");
        assertEquals("Verify text", "Hello World!", message);
    }

    public void clickNext() {
        nextButton.click();
    }

    public void clickToast() {
        toastButton.click();
    }

    public boolean isMainPage() {
        return false;
    }

}
