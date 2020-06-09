package com.zeke.lesson2;

import com.zeke.lesson2.DataProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

//@Listeners(com.zeke.lesson2.ExecutionListener.class)
public class SampleTest {

    protected static WebDriver driver;
    //private Logger logger = LogManager.getLogger(com.zeke.lesson2.SampleTest.class);
    public static DataProperties properties;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //logger.info("Драйвер поднят");
    }

    @Test
    public void openPage() {
        driver.get("http://ya.ru");
        //logger.info("Открыта страница Otus");
    }

    @Test
    public void setCookie() {

        Cookie cookie = new Cookie("Otus3", "Value3");
        driver.get("http://ya.ru");
        driver.manage().addCookie(new   Cookie("Otus1", "Value1"));
        driver.manage().addCookie(new Cookie("Otus2", "Value2"));
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(new Cookie("Otus4", "Value4"));

        System.out.println(driver.manage().getCookies());
        System.out.println(driver.manage().getCookieNamed("Otus1"));
        driver.manage().deleteCookieNamed("Otus2");
        driver.manage().deleteCookie(cookie);
        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies());
    }

    @Test
    public void implicitly1() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://otus.ru");
        driver.findElement(By.xpath("//jdiv[@class = 'hoverl_6R']"));
    }

    @Test
    public void implicitly2() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("http://otus.ru");
        driver.findElement(By.xpath("//jdiv[@class = 'hoverl_6R']"));
    }

    @Test
    public void windows1() {
        driver.manage().window().maximize();
        driver.get("http://otus.ru");
    }

    @Test
    public void windows2() {
        driver.manage().window().setSize(new Dimension(800,600));
        System.out.println(driver.manage().window().getPosition());
        driver.get("http://otus.ru");
    }

    @Test
    public void windows3() {
        driver.manage().window().setSize(new Dimension(800,600));
        System.out.println(driver.manage().window().getPosition());
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setPosition(new Point(0,600));
        driver.manage().window().setPosition(new Point(800,0));
        driver.manage().window().setPosition(new Point(800,600));
        driver.get("http://otus.ru");
    }

    @Test
    public void headless() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver1 = new ChromeDriver(options);
        driver1.get("http://otus.ru");
        driver1.findElement(By.xpath("//a[@header2__logo-img']"));
    }

    @Test
    public void wait1() {
        driver.navigate().to("http://ya.ru");
        driver.findElement(By.xpath("//span[@class = 'input__box']/a")).sendKeys("otus");
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.className("mini-suggest__item"))).click();
    }

    @Test
    public void bootstrapTest() {
        driver.navigate().to("https://ng-bootstrap.github.io/#/components/alert/examples");
        driver.findElement(By.xpath("//button[contains(text(),'Change message')]")).click();
        WebElement alertBox = driver.findElement(By.xpath("//div[@class='card-body']//ngb-alert[contains(text(), 'Message successfully changed')]"));
        String text1 = alertBox.getText();
        ExpectedConditions.not(invisibilityOf(alertBox));
        driver.findElement(By.xpath("//button[contains(text(),'Change message')]")).click();
        String text2 = alertBox.getText();
        Assert.assertNotEquals(text1, text2);
    }

    @Test
    public void alertExample(){
        driver.get("https://www.tutorialspoint.com/javascript/javascript_dialog_boxes.htm");
        // WebElement alerteframe = driver.findElement(By.cssSelector("[src='/javascript/src/alert_dialog_box.htm']"));
        driver.switchTo().frame(driver.findElement(By.cssSelector("[src='/javascript/src/alert_dialog_box.htm']")));
        driver.findElement(By.cssSelector("input")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
    }

    @AfterTest
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}