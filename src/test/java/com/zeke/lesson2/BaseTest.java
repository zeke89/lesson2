package com.zeke.lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

//@Listeners(com.zeke.lesson2.ExecutionListener.class)
public class BaseTest {

    protected static WebDriver driver;
    //private Logger logger = LogManager.getLogger(com.zeke.lesson2.SampleTest.class);

    @BeforeTest
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //logger.info("driver's been started");
    }

    @AfterTest
    public void stopBrowser() {
        driver.quit();
        //logger.info("driver's been stoped");
    }
}
