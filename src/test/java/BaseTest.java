import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {

    public WebDriver driver;

    @BeforeTest
    public void start() {

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("unexpectedAlertBehaviour", "accept");
//        ChromeOptions opt = new ChromeOptions();
//        opt.addArguments("start-fullscreen");
//        opt.addArguments("start-maximized");
//        caps.setCapability(ChromeOptions.CAPABILITY, opt);
//
//        driver = new ChromeDriver(caps);
//        System.out.println(((HasCapabilities) driver).getCapabilities());
    }

    @AfterTest
    public void stop() {
        driver.quit();
    }

    @Test
    public void testOtus() {
        driver.get("https://otus.ru");
    }
}
