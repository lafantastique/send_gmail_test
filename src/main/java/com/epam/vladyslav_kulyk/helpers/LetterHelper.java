package com.epam.vladyslav_kulyk.helpers;

import com.epam.vladyslav_kulyk.pages.LetterPage;
import com.epam.vladyslav_kulyk.utils.Waiter;

public class LetterHelper {
    private LetterPage letterPage;

    public LetterHelper() {
        letterPage = new LetterPage();
    }

    public void deleteButtonClick(){
        Waiter.waitForElement(letterPage.getDeleteButton());
        letterPage.getDeleteButton().click();
    }

    public void descriptionButtonClick() {
        Waiter.waitForElement(letterPage.getDescriptionButton());
        letterPage.getDescriptionButton().click();
    }

}
