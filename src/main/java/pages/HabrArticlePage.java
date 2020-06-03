package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class HabrArticlePage extends BasePage {

    private static final String URL = "https://habr.com/ru/company";
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    private By commentsTitle = By.xpath("//h2[@class = 'comments-section__head-title']");

    public HabrArticlePage(WebDriver driver) {
        super(driver);
    }

    public HabrArticlePage open() {
        driver.get(URL);
        return this;
    }

    public void checkCommentsTitle(String commentsTitleText) {
        assertEquals(driver.findElement(commentsTitle).getText(), commentsTitleText, "Title is not " + commentsTitleText);
    }
}
