
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

//@Listeners(ExecutionListener.class)
public class SampleTest {

    protected static WebDriver driver;
    //private Logger logger = LogManager.getLogger(SampleTest.class);
    public static DataProperties properties;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
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
    public void yandexMarketTest() {

        //-- Открыть в Chrome сайт Яндекс.Маркет - раздел "Мобильные телефоны"
        driver.navigate().to("https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?local-offers-first=0&onstock=1");
        WebElement searchInput = driver.findElement(By.xpath("//input[@id = 'header-search']"));
        //-- Отфильтровать список товаров: RedMi
        searchInput.sendKeys("Redmi");
        WebElement searchButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        searchButton.click();
        //-- Отсортировать список товаров по цене (от меньшей к большей)
        WebElement sortByPrice = driver.findElement(By.xpath("//a[contains(text(), 'по цене')]"));
        sortByPrice.click();
        sortByPrice.click();
        //-- Добавить первый в списке RedMi
        WebElement comporateButton = driver.findElements(By.xpath("//div[contains(@class, 'n-user-lists_type_compare')]")).get(0);
        comporateButton.click();
        //-- Проверить, что отобразилась плашка "Товар {имя товара} добавлен к сравнению"
        WebElement comporateNotification = driver.findElement(By.xpath("//div[contains(@class, 'popup-informer__details')]"));
        Assert.assertEquals( "Всего в списке 1 товар из категории Мобильные телефоны", comporateNotification.getText());
        // Закрыть попап со сравнением
        WebElement closeComparatePopUp = driver.findElement(By.xpath("//div[contains(@class,'popup-informer__close')]"));
        closeComparatePopUp.click();

        //- Отфильтровать список товаров: Xiaomi
        searchInput.sendKeys("Xiaomi");
        searchButton.click();
        //- Отсортировать список товаров по цене (от меньшей к большей)
        sortByPrice.click();
        //- Добавить первый в списке Xiaomi
        comporateButton.click();
        //-- Проверить, что отобразилась плашка "Товар {имя товара} добавлен к сравнению"
        Assert.assertEquals( "Всего в списке 2 товар из категории Мобильные телефоны", comporateNotification.getText());
        // Закрыть попап со сравнением
        closeComparatePopUp.click();

        //- Перейти в раздел Сравнение
        WebElement compareButton = driver.findElement(By.xpath("//a[contains(@href,'compare?track=head')]"));
        compareButton.click();

        //-- Проверить, что в списке товаров 2 позиции
        Assert.assertEquals(driver.findElements(By.xpath("//div[contains(@class, 'n-compare-cell_js_inited')]")).size(), 2);
        //- Нажать на опцию "все характеристики"
        WebElement allComparate = driver.findElement(By.xpath("//span[@class =  'link n-compare-show-controls__all']"));
        allComparate.click();
        //-- Проверить, что в списке характеристик появилась позиция "Операционная система"
        WebElement osSystem = driver.findElement(By.xpath("//div[@class='card-body']//ngb-alert[contains(text(), 'Операционная система')]"));
        ExpectedConditions.not(invisibilityOf(osSystem));
        //- Нажать на опцию "различающиеся характеристики"
        allComparate.click();
        //-- Проверить, что позиция "Операционная система" не отображается в списке характеристик
        ExpectedConditions.invisibilityOf(osSystem);

        //logger.info("Открыта страница Otus");
    }

    @AfterTest
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}