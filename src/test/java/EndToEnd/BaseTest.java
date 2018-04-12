package EndToEnd;

import EndToEnd.utils.ScreenshotListener;
import com.epam.vladyslav_kulyk.core.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners({ScreenshotListener.class})
abstract public class BaseTest {
    @BeforeTest
    public void init() {
        DriverFactory.getDriver().manage().window().fullscreen();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverFactory.getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }
}
