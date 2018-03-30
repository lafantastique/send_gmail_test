package com.epam.vladyslav_kulyk.pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class LoginPage extends BasePage {

    @Name("EmailInput")
    @FindBy(xpath = "//input[@id='identifierId']")
    private TextInput emailInput;

    @Name("PasswordInput")
    @FindBy(xpath = ".//input[@name='password']")
    private TextInput passwordInput;

    @Name("NextBtn")
    @FindBy(xpath = "//div[@id='identifierNext']/content/span")
    private Button nextButton;

    @Name("SignInBtn")
    @FindBy(xpath = "//div[@id='passwordNext']/content/span")
    private Button signInButton;

    public Button getNextButton() {
        return nextButton;
    }

    public Button getSignInButton() {
        return signInButton;
    }

    public TextInput getEmailInput() {
        return emailInput;
    }

    public TextInput getPasswordInput() {
        return passwordInput;
    }

}
