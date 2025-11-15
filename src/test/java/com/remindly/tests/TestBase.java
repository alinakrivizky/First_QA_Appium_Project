package com.remindly.tests;

import com.remindly.framework.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {
    protected ApplicationManager app=new ApplicationManager();
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();
        app.getMainscreen().confirm();
    }
    @AfterMethod(enabled=false)
    public void tearDown() {
        app.stop();
    }
}
