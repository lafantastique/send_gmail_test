package com.epam.vladyslav_kulyk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
public class InboxPage extends BasePage {

    @Name("ComposeButton")
    @FindBy(xpath = "//div[@gh='cm']")
    private Button composeButton;

    @Name("GoogleAccountIcon")
    @FindBy(xpath = "//div[@id='gb']//a[contains(@title, 'Google') and contains(@href, 'SignOut')]/span")
    private WebElement googleAccIcon;

    @Name("AccountNameLabel")
    @FindBy(xpath = "//div[@img-loaded]/div/div/div[2]")
    private TextBlock accountNameLabel;

    @Name("FieldToInCreationEmail")
    @FindBy(xpath = "//textarea[@name='to']")
    private TextBlock fieldTo;

    @Name("FieldSubjectInCreationEmail")
    @FindBy(xpath = "//input[@name='subjectbox']")
    private TextBlock fieldSubject;

    @Name("FieldBodyInCreationEmail")
    @FindBy(xpath = "//div[contains(@class, 'editable')]")
    private TextBlock fieldBody;

    @Name("ButtonSendEmail")
    @FindBy(xpath = "//tr[@class='btC']/td[1]//div[@role='button']")
    private Button buttonSend;

    @Name("SendEmailCofirmationLabel")
    @FindBy(xpath = "//span[@id='link_vsm']")
    private WebElement confirmLabel;

    @Name("LogOutButton")
    @FindBy(xpath = "//a[contains(@href, 'Logout')]")
    private Button logOutButton;

    @Name("ChangeAvatarButton")
    @FindBy(xpath = "//a[contains(@href, 'profiles')]")
    private Button changeAvatarButton;

    @Name("InboxButton")
    @FindBy(xpath = "//div[@role='navigation']//a[contains(@href, '#inbox')]")
    private Button inboxButton;

    @Name("FirstEmail")
    @FindBy(xpath = "(//div[@class='UI']//tr//div/span)[1]/../..")
    private Button firstEmail;

    public Button getChangeAvatarButton() {
        return changeAvatarButton;
    }

    public Button getFirstEmail() {
        return firstEmail;
    }

    public Button getInboxButton() {
        return inboxButton;
    }

    public Button getLogOutButton() {
        return logOutButton;
    }

    public WebElement getGoogleAccIcon() {
        return googleAccIcon;
    }

    public Button getComposeButton() {
        return composeButton;
    }

    public TextBlock getAccountNameLabel() {
        return accountNameLabel;
    }

    public TextBlock getFieldTo() {
        return fieldTo;
    }

    public TextBlock getFieldSubject() {
        return fieldSubject;
    }

    public TextBlock getFieldBody() {
        return fieldBody;
    }

    public Button getButtonSend() {
        return buttonSend;
    }

    public WebElement getConfirmLabel() {
        return confirmLabel;
    }
}
