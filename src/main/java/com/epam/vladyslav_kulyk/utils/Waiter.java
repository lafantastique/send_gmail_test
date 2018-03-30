package com.epam.vladyslav_kulyk.utils;

import com.epam.vladyslav_kulyk.core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private static WebDriverWait wait;

    static {
        wait = (new WebDriverWait(Driver.getDriver(), 10));
    }
    public static void waitForElement(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public static void waitForUrlContains(String url){
        wait.until(ExpectedConditions.urlContains(url));
    }
}
