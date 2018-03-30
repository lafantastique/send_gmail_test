package EndToEnd;

import com.epam.vladyslav_kulyk.core.Driver;
import com.epam.vladyslav_kulyk.pages.InboxPage;
import com.epam.vladyslav_kulyk.pages.LetterPage;
import com.epam.vladyslav_kulyk.pages.LoginPage;
import com.epam.vladyslav_kulyk.pages.helpers.InboxHelper;
import com.epam.vladyslav_kulyk.pages.helpers.LoginHelper;
import com.epam.vladyslav_kulyk.utils.Waiter;
import se.emirbuc.randomsentence.RandomSentences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSendEmail extends BaseTest {
    private LoginHelper loginHelper;
    private InboxHelper inboxHelper;
    private InboxPage inboxPage;
    private LetterPage letterPage;
    private LoginPage loginPage;
    private WebDriverWait wait = (new WebDriverWait(Driver.getDriver(), 10));
    private String randSubject;
    @BeforeClass
    public void openMainPage() {
        Driver.getDriver().get("https://gmail.com");
        loginHelper = new LoginHelper();
        inboxHelper = new InboxHelper();
        inboxPage = new InboxPage();
        letterPage = new LetterPage();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void logIn() throws InterruptedException {
        loginHelper.login("btestovickij@gmail.com", "zxcvbnm98765432");
        Waiter.waitForElement(inboxPage.getGoogleAccIcon());
        inboxHelper.clickOnAccountIcon();
        Waiter.waitForElement(inboxPage.getAccountNameLabel());
        Assert.assertTrue(inboxHelper.getAccountName().contains("btestovickij@gmail.com"));
    }

    @Test(priority = 2)
    public void sendEmail(){
        randSubject = RandomSentences.generateRandomSentence(null);
        inboxHelper.createAndSendEmail("btestovickij@gmail.com", randSubject, "Some great letter!");
        Waiter.waitForElement(inboxPage.getConfirmLabel());
        Assert.assertTrue(inboxPage.getConfirmLabel().isDisplayed());
    }

    @Test(priority = 3)
    public void checkForRecievedEmail(){
        inboxPage.getInboxButton().click();
        Waiter.waitForUrlContains("#inbox");
        inboxPage.getEmailBySubject(randSubject).click();
        Waiter.waitForElement(letterPage.getDescriptionButton());
        letterPage.getDescriptionButton().click();
        Assert.assertEquals(letterPage.getAdressString(), "btestovickij@gmail.com");
        Assert.assertEquals(letterPage.getSubject().getText(), randSubject);
        Assert.assertEquals(letterPage.getLetter().getText(), "Some great letter!");
    }

    @AfterClass
    public void deleteEmailAndLogOu() {
        letterPage.getDeleteButton().click();
        inboxHelper.clickOnAccountIcon();
        inboxHelper.clickOnLogOutButton();
        Waiter.waitForElement(loginPage.getPasswordInput());
    }

}
