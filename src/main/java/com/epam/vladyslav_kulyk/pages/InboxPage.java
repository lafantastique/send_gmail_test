package com.epam.vladyslav_kulyk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class InboxPage extends BasePage {

    @FindBy(xpath = "//div[@gh='cm']")
    private WebElement composeButton;

    @FindBy(xpath = "//div[@id='gb']//a[contains(@title, 'Google') and contains(@href, 'SignOut')]/span")
    private WebElement googleAccIcon;

    @FindBy(xpath = "//div[@img-loaded]/div/div/div[2]")
    private WebElement accountNameLabel;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement fieldTo;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement fieldSubject;

    @FindBy(xpath = "//div[contains(@class, 'editable')]")
    private WebElement fieldBody;

    @FindBy(xpath = "//tr[@class='btC']/td[1]//div[@role='button']")
    private WebElement buttonSend;

    @FindBy(xpath = "//span[@id='link_vsm']")
    private WebElement confirmLabel;

    @FindBy(xpath = "//a[contains(@href, 'Logout')]")
    private WebElement logOutButton;

    @FindBy(xpath = "//a[contains(@href, 'profiles')]")
    private WebElement changeAvatarButton;

    @FindBy(xpath = "//div[@role='navigation']//a[contains(@href, '#inbox')]")
    private WebElement inboxButton;

    @FindBy(xpath = "(//div[@class='UI']//tr//div/span)[1]/../..")
    private WebElement firstEmail;

    public WebElement getChangeAvatarButton() {
        return changeAvatarButton;
    }

    public WebElement getFirstEmail() {
        return firstEmail;
    }

    public WebElement getInboxButton() {
        return inboxButton;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public WebElement getGoogleAccIcon() {
        return googleAccIcon;
    }

    public WebElement getComposeButton() {
        return composeButton;
    }

    public WebElement getAccountNameLabel() {
        return accountNameLabel;
    }

    public WebElement getFieldTo() {
        return fieldTo;
    }

    public WebElement getFieldSubject() {
        return fieldSubject;
    }

    public WebElement getFieldBody() {
        return fieldBody;
    }

    public WebElement getButtonSend() {
        return buttonSend;
    }

    public WebElement getConfirmLabel() {
        return confirmLabel;
    }
}
