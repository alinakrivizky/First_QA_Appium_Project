package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReminderTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        app.getMainscreen().tapAddReminder();
        app.getReminder().enterReminderTitle("Wake up, freak");
    }
    @Test
    public void addReminderTitleTest(){
        app.getReminder().enterReminderTitle("Wake up, freak");
        app.getReminder().tapSaveReminder();
        Assert.assertTrue(app.getMainscreen().isReminderTitlePresent().contains("Wake up, freak"));
    }
    @Test
    public void addReminderDateTest(){
        app.getReminder().tapOnDateField();
        app.getReminder().swipeToMonth("future","NOV",2);
        app.getReminder().selectDate(13);
        app.getReminder().tapOnYear();
        app.getReminder().swipeToYear("future","2027");
        app.getReminder().tapOnOk();
        app.getReminder().tapSaveReminder();

        Assert.assertTrue(app.getMainscreen().isReminderDateTimePresent().contains("14/11/2027"));
    }
    @Test
    public void addReminderTimeTest(){
        app.getReminder().tapOnTimeField();
        app.getReminder().selectTimeOfDay("AM");
        app.getReminder().selectTime(2,15);
        app.getReminder().tapOnOk();
        app.getReminder().tapSaveReminder();
        Assert.assertTrue(app.getMainscreen().isReminderDateTimePresent().contains("2:15 AM"));


    }
}
