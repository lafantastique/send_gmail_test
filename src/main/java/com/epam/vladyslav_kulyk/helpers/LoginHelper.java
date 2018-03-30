package com.epam.vladyslav_kulyk.helpers;

import com.epam.vladyslav_kulyk.pages.LoginPage;
import com.epam.vladyslav_kulyk.utils.Waiter;


public class LoginHelper {
    private LoginPage loginPage;

    public LoginHelper() {
        loginPage = new LoginPage();
    }

    public void login(String login, String password) {
        loginPage.getEmailInput().click();
        loginPage.getEmailInput().sendKeys(login);
        loginPage.getNextButton().click();
        Waiter.waitForElement(loginPage.getPasswordInput());
        loginPage.getPasswordInput().click();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getSignInButton().click();
    }
}
