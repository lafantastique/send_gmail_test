package com.epam.vladyslav_kulyk.core;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static WebDriver driver;

    static {
        driver = DriverType.valueOf(System.getProperty("browserType")).create();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
