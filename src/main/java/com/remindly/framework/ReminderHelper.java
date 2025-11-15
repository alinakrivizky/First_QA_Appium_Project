package com.remindly.framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends BaseHelper {
    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void enterReminderTitle(String title) {
        type(By.id("reminder_title"), title);

    }

    public void tapSaveReminder() {
        tap(By.id("save_reminder"));
    }

    public void tapOnDateField() {
        tap(By.id("date"));
    }

    public void swipeToMonth(String period, String month, int swipeCount) {
        if (!getSelectedMonth().equals(month)) {
            for (int i = 0; i < swipeCount; i++) {
                if (period.equals("future")) {
                    swipe(0.8, 0.4);
                } else if (period.equals("past")) {
                    swipe(0.5, 0.9);
                }
            }
        }
    }


    private String getSelectedMonth() {

        return isTextPresent(By.id("date_picker_month"));
    }

    public void selectDate(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void tapOnYear() {
        tap(By.id("date_picker_year"));
    }

    public void swipeToYear(String period, String year) {
        pause(500);
        if (!getSelectedYear().equals(year)) {
            if (period.equals("future")) {
                untilNeededYear(year, 0.6, 0.5);
            } else if (period.equals("past")) {
                untilNeededYear(year, 0.5, 0.6);
            }
        }
        tap(By.id("month_text_view"));
    }

    private String getSelectedYear() {
        return isTextPresent(By.id("date_picker_year"));
    }

    private void untilNeededYear(String year, double start, double stop) {
        while (!getYear().equals(year)) {
            swipe(start, stop);
        }
        getYear();
    }

    private String getYear() {
        return isTextPresent(By.id("month_text_view"));
    }

    public void tapOnOk() {
        tap(By.id("ok"));
    }

    public void tapOnTimeField() {
        tap(By.id("com.blanyal.remindly:id/time"));
    }

    public void selectTimeOfDay(String period) {
        tap(By.id("com.blanyal.remindly:id/ampm_label"));
        System.out.println("Selected time period: " + period);
    }

    public void selectTime(int hour, int minute) {
        By hoursButton = By.id("com.blanyal.remindly:id/hours");
        waitForElement(hoursButton, 10);
        tap(hoursButton);
        pause(300);
        By hourLocator = By.xpath("//android.widget.FrameLayout[@content-desc=\"Hours circular slider: " + hour + "\"]/android.view.View[4]");
        waitForElement(hourLocator, 10);
        tap(hourLocator);
        System.out.println("Selected hour: " + hour);
        pause(300);

        By minutesButton = By.id("com.blanyal.remindly:id/minutes");
        waitForElement(minutesButton, 10);
        tap(minutesButton);
        pause(300);
        By minuteLocator = By.xpath("//android.widget.FrameLayout[@content-desc=\"Minutes circular slider: " + minute + "\"]/android.view.View[4]");
        waitForElement(minuteLocator, 10);
        tap(minuteLocator);
        System.out.println("Selected minutes: " + minute);
        pause(300);

    }
}


