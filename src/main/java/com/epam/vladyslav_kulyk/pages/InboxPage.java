package com.epam.vladyslav_kulyk.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class InboxPage extends BasePage {

    @FindBy(xpath = "//div[@gh='cm']")
    private WebElement composeButton;

    @FindBy(xpath = "//div[@id='gb']//a[contains(@title, 'Google') and contains(@href, 'SignOut')]")
    private WebElement googleAccIcon;

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

    @FindBy(xpath = "//div[@role='navigation']//a[contains(@href, '#inbox')]")
    private WebElement inboxButton;

    public WebElement getInboxButton() {
        return inboxButton;
    }

    public WebElement getGoogleAccIcon() {
        return googleAccIcon;
    }

    public WebElement getComposeButton() {
        return composeButton;
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
