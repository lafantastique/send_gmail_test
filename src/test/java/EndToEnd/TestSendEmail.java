package EndToEnd;

import com.epam.vladyslav_kulyk.core.Driver;
import com.epam.vladyslav_kulyk.helpers.LetterHelper;
import com.epam.vladyslav_kulyk.pages.InboxPage;
import com.epam.vladyslav_kulyk.pages.LetterPage;
import com.epam.vladyslav_kulyk.pages.LoginPage;
import com.epam.vladyslav_kulyk.helpers.InboxHelper;
import com.epam.vladyslav_kulyk.helpers.LoginHelper;
import com.epam.vladyslav_kulyk.utils.Waiter;
import se.emirbuc.randomsentence.RandomSentences;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSendEmail extends BaseTest {
    private LoginHelper loginHelper;
    private InboxHelper inboxHelper;
    private LetterHelper letterHelper;
    private InboxPage inboxPage;
    private LetterPage letterPage;
    private LoginPage loginPage;
    private String randSubject;

    @BeforeClass
    public void openMainPage() {
        Driver.getDriver().get("https://gmail.com");
        loginHelper = new LoginHelper();
        inboxHelper = new InboxHelper();
        letterHelper = new LetterHelper();
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
        inboxHelper.clickInboxButton();
        Waiter.waitForUrlContains("#inbox");
        inboxHelper.getEmailBySubject(randSubject).click();
        Waiter.waitForElement(letterPage.getDescriptionButton());
        letterHelper.descriptionButtonClick();
        Assert.assertEquals(letterPage.getAdressString(), "btestovickij@gmail.com");
        Assert.assertEquals(letterPage.getSubject().getText(), randSubject);
        Assert.assertEquals(letterPage.getLetter().getText(), "Some great letter!");
    }

    @AfterClass
    public void deleteEmailAndLogOu() {
        letterHelper.deleteButtonClick();
        inboxHelper.clickOnAccountIcon();
        inboxHelper.clickOnLogOutButton();
    }
}
