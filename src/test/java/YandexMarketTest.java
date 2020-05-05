import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(ExecutionListener.class)
public class YandexMarketTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("Драйвер поднят");
    }

    @Test
    public void yandexMarketTest() {

        openSmartPhoneMarket();

        filterByName("Redmi");
        sortByPrice();
        addToCompare();
        checkNotification("Всего в списке 1 товар из категории Мобильные телефоны");
        closeNotification();

        filterByName("Xiaomi");
        sortByPrice();
        addToCompare();
        checkNotification( "Всего в списке 2 товара из категории Мобильные телефоны");
        closeNotification();

        openCompareMarket();
        checkCountCompare(2);
        clickAllParameters();
        checkExistOsParameter(true);
        clickDiffParameters();
        checkExistOsParameter(false);
    }

    public void openSmartPhoneMarket() {
        driver.navigate().to("https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?local-offers-first=0&onstock=1");
        logger.info("Открыта страница Яндекс Маркет/ Мобильные телефоны");
    }

    public void filterByName(String phoneName) {
        WebElement searchInput = driver.findElement(By.xpath("//input[@id = 'header-search']"));
        searchInput.clear();
        searchInput.sendKeys(phoneName);
        WebElement searchButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        ExpectedConditions.elementToBeClickable(searchButton);
        searchButton.click();
    }

    public void sortByPrice() {
        WebElement listOfPhones = driver.findElement(By.xpath("//div[contains(@class, 'n-snippet-list')]"));
        WebElement filtersPanel = driver.findElement(By.cssSelector("div.n-filter-block_pos_left.i-bem"));
        filtersPanel.findElement(By.xpath(".//a[text()='по цене']")).click();
        ExpectedConditions.stalenessOf(listOfPhones);
        logger.info("Список отсортирован по цене");
    }

    public void addToCompare() {
        WebElement compareButton = driver.findElements(By.xpath("//div[contains(@class, 'n-user-lists_type_compare')]")).get(0);
        Actions action = new Actions(driver);
        action.moveToElement(compareButton).build().perform();
        ExpectedConditions.elementToBeClickable(compareButton);
        compareButton.click();
    }

    public void checkNotification(String notificationText) {
        WebElement compareNotification = driver.findElement(By.xpath("//div[contains(@class, 'popup-informer__details')]"));
        Assert.assertEquals(compareNotification.getText(), notificationText);
        logger.info("Добавлен в сравнение");
    }

    public void closeNotification() {
        WebElement closeComparePopUp = driver.findElement(By.xpath("//div[contains(@class,'popup-informer__close')]"));
        ExpectedConditions.elementToBeClickable(closeComparePopUp);
        closeComparePopUp.click();
    }

    public void openCompareMarket() {
        WebElement compareButton = driver.findElement(By.xpath("//a[contains(@href,'compare?track=head')]"));
        ExpectedConditions.elementToBeClickable(compareButton);
        compareButton.click();
        logger.info("Открыта страница сравнения товаров");
    }

    public void checkCountCompare(int compareSize) {
        Assert.assertEquals(driver.findElements(By.xpath("//div[contains(@class, 'n-compare-cell_js_inited')]")).size(), compareSize);
        logger.info("Кол-во товаров соответствует нужному");
    }

    public void clickAllParameters() {
        WebElement allCompare = driver.findElement(By.xpath("//span[@class =  'link n-compare-show-controls__all']"));
        ExpectedConditions.elementToBeClickable(allCompare);
        allCompare.click();
    }

    public void clickDiffParameters() {
        WebElement diffCompare = driver.findElement(By.xpath(" //span[contains(@class,  'n-compare-show-controls__diff')]"));
        ExpectedConditions.elementToBeClickable(diffCompare);
        diffCompare.click();
    }

    public void checkExistOsParameter(boolean isExist) {
        if (isExist) {
            WebElement osSystem = driver.findElement(By.xpath("//div[@class='n-compare-content layout_context_compare i-bem']//div[contains(text(), 'Операционная система')]"));
            ExpectedConditions.visibilityOf(osSystem);
            logger.info("В сравниваемых параметрах есть параметр 'Операционная система'");
        } else {
            WebElement osSystem = driver.findElement(By.xpath("//div[@class='n-compare-content layout_context_compare i-bem']//div[contains(text(), 'Операционная система')]"));
            ExpectedConditions.invisibilityOf(osSystem);
            logger.info("В сравниваемых параметрах нет параметра 'Операционная система'");
        }
    }

    @AfterTest
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}