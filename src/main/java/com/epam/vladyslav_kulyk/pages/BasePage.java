package com.epam.vladyslav_kulyk.pages;

import com.epam.vladyslav_kulyk.core.Driver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

abstract class BasePage {

    BasePage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(Driver.getDriver())), this);
    }
}
