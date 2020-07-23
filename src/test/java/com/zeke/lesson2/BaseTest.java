package com.zeke.lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    //protected static RemoteWebDriver driver;

    protected static ChromeDriver driver;

    @BeforeTest
    public void startBrowser() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("81.0");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", false);
//
//        driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub/").toURL(), capabilities);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void stopBrowser() {
        driver.quit();
    }
}
