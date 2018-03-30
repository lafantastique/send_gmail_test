package com.epam.vladyslav_kulyk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement emailInput;

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@id='identifierNext']/content/span")
    private WebElement nextButton;

    @FindBy(xpath = "//div[@id='passwordNext']/content/span")
    private WebElement signInButton;

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

}
