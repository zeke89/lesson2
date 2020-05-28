import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

//@Listeners(ExecutionListener.class)
public class BaseTest {

    protected static WebDriver driver;
    //private Logger logger = LogManager.getLogger(SampleTest.class);

    @BeforeTest
    public void startBrowser() {

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("unexpectedAlertBehaviour", "accept");
//        ChromeOptions opt = new ChromeOptions();
//        opt.addArguments("start-fullscreen");
//        opt.addArguments("start-maximized");
//        caps.setCapability(ChromeOptions.CAPABILITY, opt);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //logger.info("Драйвер поднят");
    }

    @AfterTest
    public void stopBrowser() {
        driver.quit();
    }
}
