package com.remindly.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;

import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Arrays;
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
            driver.findElement(hoursButton).click();
            pause(500);
            int left = 168, top = 688, right = 867, bottom = 1513;
            int centerX = (left + right) / 2;
            int centerY = (top + bottom) / 2;
            int radius = Math.min(right - left, bottom - top) / 2;
            int hourRadius = (int)(radius * 0.85);
            double hourAngle = Math.toRadians((hour % 12) * 30);
            int hourX = centerX + (int)(hourRadius * Math.sin(hourAngle));
            int hourY = centerY - (int)(hourRadius * Math.cos(hourAngle));

            new TouchAction((PerformsTouchActions) driver)
                    .tap(PointOption.point(hourX, hourY))
                    .perform();
            pause(500);


            By minutesButton = By.id("com.blanyal.remindly:id/minutes");
            driver.findElement(minutesButton).click();
            pause(500);

            int minuteRadius = (int)(radius * 0.85);
            double minuteAngle = Math.toRadians(minute * 6-4);
            int minuteX = centerX + (int)(minuteRadius * Math.sin(minuteAngle));
            int minuteY = centerY - (int)(minuteRadius * Math.cos(minuteAngle));

            new TouchAction((PerformsTouchActions) driver)
                    .tap(PointOption.point(minuteX, minuteY))
                    .perform();
            pause(500);
        }
    }




