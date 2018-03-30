package EndToEnd;

import com.epam.vladyslav_kulyk.core.Driver;
import com.epam.vladyslav_kulyk.pages.InboxPage;
import com.epam.vladyslav_kulyk.pages.LetterPage;
import com.epam.vladyslav_kulyk.pages.LoginPage;
import com.epam.vladyslav_kulyk.pages.helpers.InboxHelper;
import com.epam.vladyslav_kulyk.pages.helpers.LoginHelper;
import org.openqa.selenium.Alert;
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
        wait.until(ExpectedConditions.visibilityOf(inboxPage.getGoogleAccIcon()));
        inboxHelper.clickOnAccountIcon();
        wait.until(ExpectedConditions.visibilityOf(inboxPage.getChangeAvatarButton()));
        Assert.assertTrue(inboxHelper.getAccountName().contains("btestovickij@gmail.com"));
    }

    @Test(priority = 2)
    public void sendEmail(){
        inboxHelper.createAndSendEmail("btestovickij@gmail.com", "subject1", "Some great letter!");
        wait.until(ExpectedConditions.visibilityOf(inboxPage.getConfirmLabel()));
        Assert.assertTrue(inboxPage.getConfirmLabel().isDisplayed());
    }

    @Test(priority = 3)
    public void checkForRecievedEmail(){
        inboxPage.getInboxButton().click();
        wait.until(ExpectedConditions.urlContains("#inbox"));
        inboxPage.getFirstEmail().click();
        wait.until(ExpectedConditions.visibilityOf(letterPage.getDescriptionButton()));
        letterPage.getDescriptionButton().click();
        Assert.assertEquals(letterPage.getAdressString(), "btestovickij@gmail.com");
        Assert.assertEquals(letterPage.getSubject().getText(), "subject1");
        Assert.assertEquals(letterPage.getLetter().getText(), "Some great letter!");
    }

    @AfterClass
    public void deleteEmail() throws InterruptedException {
        letterPage.getDeleteButton().click();
        inboxHelper.clickOnAccountIcon();
        wait.until(ExpectedConditions.visibilityOf(inboxPage.getChangeAvatarButton()));
        inboxPage.getLogOutButton().click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getPasswordInput()));
    }

}
