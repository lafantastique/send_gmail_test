package EndToEnd;

import com.epam.vladyslav_kulyk.core.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

abstract public class BaseTest {
    @BeforeTest
    public void init() {
        Driver.getDriver().manage().window().fullscreen();
        Driver.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        Driver.getDriver().quit();
    }
}
