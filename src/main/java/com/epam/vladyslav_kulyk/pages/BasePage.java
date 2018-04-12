package com.epam.vladyslav_kulyk.pages;

import com.epam.vladyslav_kulyk.core.DriverFactory;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {
    BasePage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
}
