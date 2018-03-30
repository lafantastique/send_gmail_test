package com.epam.vladyslav_kulyk.pages;

import com.epam.vladyslav_kulyk.core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class InboxPage extends BasePage {

    @FindBy(xpath = "//div[@gh='cm']")
    private WebElement composeButton;

    @FindBy(xpath = "//div[@id='gb']//a[contains(@title, 'Google') and contains(@href, 'SignOut')]/span")
    private WebElement googleAccIcon;

    @FindBy(xpath = "//div[contains(@class,'gb_Ib')]")
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

    public WebElement getChangeAvatarButton() {
        return changeAvatarButton;
    }

    public WebElement getEmailBySubject(String subject) {
        String xPath = "//span/b[contains(text(), '" + subject + "')]";
        return Driver.getDriver().findElement(By.xpath(xPath));
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
