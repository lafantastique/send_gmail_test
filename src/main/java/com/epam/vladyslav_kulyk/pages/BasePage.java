package com.epam.vladyslav_kulyk.pages;

import com.epam.vladyslav_kulyk.core.Driver;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {
    BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
