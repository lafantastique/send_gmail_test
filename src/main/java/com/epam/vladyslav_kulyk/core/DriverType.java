package com.epam.vladyslav_kulyk.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum DriverType {
    CHROME {
        public WebDriver create() {
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
            return new ChromeDriver();
        }
    };

    public WebDriver create(){
        return null;
    }
}
