package com.remindly.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ApplicationManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;
    MainScreenHelper mainscreen;
    ReminderHelper reminder;

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName", "Pixel 4");
        capabilities.setCapability("appPackage", "com.blanyal.remindly");
        capabilities.setCapability("appActivity", "com.blanyal.remindme.MainActivity");
        capabilities.setCapability("appium", "appActivity");
        capabilities.setCapability("app", "/Users/alinakrivizky/Documents/Remindly1.1.apk");

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        mainscreen = new MainScreenHelper(driver);
        reminder = new ReminderHelper(driver);
    }
    public void stop() {
        driver.quit();
    }

    public ReminderHelper getReminder() {
        return reminder;
    }

    public MainScreenHelper getMainscreen() {
        return mainscreen;
    }
}


