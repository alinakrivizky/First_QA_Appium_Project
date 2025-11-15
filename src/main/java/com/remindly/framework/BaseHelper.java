package com.remindly.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHelper {
    TouchAction touchAction;
    protected AppiumDriver driver;
    public BaseHelper(AppiumDriver driver) {
        this.driver = driver;
        touchAction=new TouchAction<>((PerformsTouchActions)driver);
    }
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
    public void type(By locator, String text) {
        if (text != null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
        driver.navigate().back(); //to remove phone's keyboard
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String isTextPresent(By locator){

        return driver.findElement(locator).getText();
    }
    public void swipe(double start, double stop){
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() /2;
        int startY = (int) (size.getHeight() * start);
        int stopY = (int) (size.getHeight() * stop);
        touchAction.longPress(PointOption.point(x, startY))
                .moveTo(PointOption.point(x, stopY))
                .release().perform();
    }
    public WebElement waitForElement(By locator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
