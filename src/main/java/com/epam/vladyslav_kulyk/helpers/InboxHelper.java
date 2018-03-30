package com.epam.vladyslav_kulyk.helpers;

import com.epam.vladyslav_kulyk.core.Driver;
import com.epam.vladyslav_kulyk.pages.InboxPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxHelper {
    private InboxPage inboxPage;
    private WebDriverWait wait = (new WebDriverWait(Driver.getDriver(), 10));


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
        wait.until(ExpectedConditions.visibilityOf(inboxPage.getLogOutButton()));
        inboxPage.getLogOutButton().click();
    }

    public void createEmailclick(){
        inboxPage.getComposeButton().click();
    }
    public void clickInbox(){
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
