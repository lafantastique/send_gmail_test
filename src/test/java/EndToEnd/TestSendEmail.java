package EndToEnd;

import com.epam.vladyslav_kulyk.core.DriverFactory;
import com.epam.vladyslav_kulyk.helpers.LetterHelper;
import com.epam.vladyslav_kulyk.pages.InboxPage;
import com.epam.vladyslav_kulyk.pages.LetterPage;
import com.epam.vladyslav_kulyk.helpers.InboxHelper;
import com.epam.vladyslav_kulyk.helpers.LoginHelper;
import se.emirbuc.randomsentence.RandomSentences;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSendEmail extends BaseTest {
    private LoginHelper loginHelper;
    private InboxHelper inboxHelper;
    private LetterHelper letterHelper;
    private InboxPage inboxPage;
    private LetterPage letterPage;
    private String randSubject;
    private String randText;


    @BeforeClass
    public void openMainPage() {
        DriverFactory.getDriver().get("https://gmail.com");
        loginHelper = new LoginHelper();
        inboxHelper = new InboxHelper();
        letterHelper = new LetterHelper();
        inboxPage = new InboxPage();
        letterPage = new LetterPage();
    }

    @Test(priority = 1)
    public void checkLogIn() {
        loginHelper.login("btestovickij@gmail.com", "zxcvbnm98765432");
        Assert.assertTrue(inboxHelper.getAccountName().contains("btestovickij@gmail.com"));

    }

    @Test(priority = 2)
    public void sendEmail(){
        randSubject = RandomSentences.generateRandomSentence(null);
        randText = RandomSentences.generateRandomSentence(RandomSentences.Length.LONG);
        inboxHelper.createAndSendEmail("btestovickij@gmail.com", randSubject, randText);
        Assert.assertTrue(inboxPage.getConfirmLabel().isDisplayed());
    }

    @Test(priority = 3)
    public void checkForReceivedEmail() {
        inboxHelper.clickInboxButton();
        inboxHelper.getEmailBySubject(randSubject).click();
        letterHelper.descriptionButtonClick();
        Assert.assertTrue(letterPage.getAddressFrom().isDisplayed());
        Assert.assertEquals(letterPage.getSubject().getText(), randSubject);
        Assert.assertEquals(letterPage.getLetter().getText(), randText);
        letterHelper.deleteButtonClick();
    }


}
