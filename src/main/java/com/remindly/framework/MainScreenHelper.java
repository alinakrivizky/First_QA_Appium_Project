package com.remindly.framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.Collection;

public class MainScreenHelper extends BaseHelper {
    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }
public boolean noReminderPresent() {
        return isElementPresent(By.id("no_reminder_text"));
}
public void confirm(){
        tap(By.id("android:id/button1"));
}

    public void tapAddReminder() {
        tap(By.id("add_reminder"));
    }

    public String isReminderTitlePresent() {
        return driver.findElement(By.id("recycle_title")).getText();
    }

    public String isReminderDateTimePresent() {

        return isTextPresent(By.id("com.blanyal.remindly:id/set_date"));
    }
}
