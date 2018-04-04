package com.epam.vladyslav_kulyk.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum DriverType {
    CHROME {
        public WebDriver create(){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    },
    FIREFOX {
        public WebDriver create() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    };

    public WebDriver create(){
        return null;
    }
}
