package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTest extends TestBase{
    @Test
public void noReminderPresent(){
        Assert.assertTrue(app.getMainscreen().noReminderPresent());
    }
}
