package com.epam.vladyslav_kulyk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

public class LetterPage extends BasePage {

    @Name("AddressFrom")
    @FindBy(xpath = "//div[contains(@class,'ajA')]//tbody/tr[1]/td[2]/span/span[1]")
    private Button addressFrom;

    @Name("DescriptionButton")
    @FindBy(xpath = "//img[contains(@class,'ajz')]/..")
    private WebElement descriptionButton;

    @Name("Subject")
    @FindBy(xpath = "//div[@role='main']//h2")
    private Button subject;

    @Name("Letter")
    @FindBy(xpath = "//div[@role='main']//div[@dir='ltr']")
    private Button letter;

    @Name("DeleteButton")
    @FindBy(xpath = "//div[@act=10]")
    private Button deleteButton;

    public WebElement getDescriptionButton() {
        return descriptionButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getLetter() {
        return letter;
    }

    public Button getSubject() {
        return subject;
    }

    public Button getAddressFrom() {
        return addressFrom;
    }

    public String getAdressString() {
        return getAddressFrom().getAttribute("email");
    }
}
