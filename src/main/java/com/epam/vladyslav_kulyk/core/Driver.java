package com.epam.vladyslav_kulyk.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driver {

    private static WebDriver driver;

    static {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
