package com.epam.vladyslav_kulyk.utils;

import com.epam.vladyslav_kulyk.core.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private final static WebDriverWait wait;

    static {
        wait =  new WebDriverWait(DriverFactory.getDriver(), 5);
    }

    public static void waitForElement(WebElement webElement) {
        wait.withMessage("Element ["+ webElement.toString()+"] was not found").until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForUrlContains(String url) {
        wait.until(ExpectedConditions.urlContains(url));
    }

}
