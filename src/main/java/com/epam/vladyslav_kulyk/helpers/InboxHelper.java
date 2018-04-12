package com.epam.vladyslav_kulyk.helpers;

import com.epam.vladyslav_kulyk.core.DriverFactory;
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
        return inboxPage.getGoogleAccIcon().getAttribute("title");
    }

    public WebElement getEmailBySubject(String subject) {
        String xPath = "//span/b[contains(text(), '" + subject + "')]";
        return DriverFactory.getDriver().findElement(By.xpath(xPath));
    }

    public void clickInboxButton(){
        inboxPage.getInboxButton().click();
        Waiter.waitForUrlContains("#inbox");
    }

    public void createAndSendEmail(String to, String subject, String message){
        inboxPage.getComposeButton().click();
        inboxPage.getFieldTo().sendKeys(to);
        inboxPage.getFieldSubject().sendKeys(subject);
        inboxPage.getFieldBody().sendKeys(message);
        inboxPage.getButtonSend().click();
        Waiter.waitForElement(inboxPage.getConfirmLabel());
    }
}
