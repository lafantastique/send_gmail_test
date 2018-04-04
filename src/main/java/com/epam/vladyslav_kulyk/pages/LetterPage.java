package com.epam.vladyslav_kulyk.pages;

import com.epam.vladyslav_kulyk.core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends BasePage {

    @FindBy(xpath = "(//span[@data-hovercard-id='btestovickij@gmail.com'])[3]")
    private WebElement addressFrom;

    @FindBy(xpath = "//img[contains(@class,'ajz')]")
    private WebElement descriptionButton;

    @FindBy(xpath = "//div[@role='main']//h2")
    private WebElement subject;

    @FindBy(xpath = "//div[@role='main']//div[@dir='ltr']")
    private WebElement letter;

    @FindBy(xpath = "(//div[@act=10])[last()]")
    private WebElement deleteButton;

    public WebElement getDescriptionButton() {
        return descriptionButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getLetter() {
        return letter;
    }

    public WebElement getSubject() {
        return subject;
    }

    public WebElement getAddressFrom() {
        return addressFrom;
    }

    //public String getAdressString() {
//        return getAddressFrom().getAttribute("jid");
//    }
}
