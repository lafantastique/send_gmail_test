package com.epam.vladyslav_kulyk.helpers;

import com.epam.vladyslav_kulyk.pages.LetterPage;
import com.epam.vladyslav_kulyk.utils.Waiter;

public class LetterHelper {
    private LetterPage letterPage;

    public LetterHelper() {
        letterPage = new LetterPage();
    }

    public void deleteButtonClick(){
        letterPage.getDeleteButton().click();
    }

    public void descriptionButtonClick() {
        Waiter.waitForElement(letterPage.getDescriptionButton());
        letterPage.getDescriptionButton().click();
    }

}
