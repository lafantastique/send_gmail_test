package com.epam.vladyslav_kulyk.helpers;

import com.epam.vladyslav_kulyk.core.Driver;
import com.epam.vladyslav_kulyk.pages.InboxPage;
import com.epam.vladyslav_kulyk.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InboxHelper {
    private InboxPage inboxPage;


    public InboxHelper() {
        inboxPage = new InboxPage();
    }

    public String getAccountName() {
        return inboxPage.getAccountNameLabel().getText();
    }
    public void clickOnAccountIcon(){
        inboxPage.getGoogleAccIcon().click();
    }

    public void clickOnLogOutButton(){
        Waiter.waitForElement(inboxPage.getLogOutButton());
        inboxPage.getLogOutButton().click();
    }

    public WebElement getEmailBySubject(String subject) {
        String xPath = "//span/b[contains(text(), '" + subject + "')]";
        return Driver.getDriver().findElement(By.xpath(xPath));
    }

    public void clickInboxButton(){
        inboxPage.getInboxButton().click();
    }

    public void createAndSendEmail(String to, String subject, String message){
        inboxPage.getComposeButton().click();
        inboxPage.getFieldTo().sendKeys(to);
        inboxPage.getFieldSubject().sendKeys(subject);
        inboxPage.getFieldBody().sendKeys(message);
        inboxPage.getButtonSend().click();
    }

}
