package com.epam.vladyslav_kulyk.helpers;

import com.epam.vladyslav_kulyk.core.Driver;
import com.epam.vladyslav_kulyk.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginHelper {
    private LoginPage loginPage;

    public LoginHelper() {
        loginPage = new LoginPage();
    }
    private WebDriverWait wait = (new WebDriverWait(Driver.getDriver(), 10));

    public void login(String login, String password) throws InterruptedException {
        loginPage.getEmailInput().click();
        loginPage.getEmailInput().sendKeys(login);
        loginPage.getNextButton().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getPasswordInput()));
        loginPage.getPasswordInput().click();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getSignInButton().click();
    }
}
