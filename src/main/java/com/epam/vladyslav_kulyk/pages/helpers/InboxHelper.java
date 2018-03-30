package com.epam.vladyslav_kulyk.pages.helpers;

import com.epam.vladyslav_kulyk.pages.InboxPage;

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
    public void createEmailclick(){
        inboxPage.getComposeButton().click();
    }
    public void clickInbox(){
        inboxPage.getInboxButton().click();
    }

    public void clickFirstEmail(){
        inboxPage.getFirstEmail().click();
    }

    public void createAndSendEmail(String to, String subject, String message){
        inboxPage.getComposeButton().click();
        inboxPage.getFieldTo().sendKeys(to);
        inboxPage.getFieldSubject().sendKeys(subject);
        inboxPage.getFieldBody().sendKeys(message);
        inboxPage.getButtonSend().click();
    }
}
