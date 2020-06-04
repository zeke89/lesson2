package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class HabrSandboxPage extends BasePage {

    private static final String URL = "https://habr.com/ru/sandbox/add/";
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    private final By editor = By.xpath("///div[@class = 'tm-editor']");
    private final By titleSandboxPage = By.xpath("//h1[@class = 'page-header__title']");

    public HabrSandboxPage(WebDriver driver) {
        super(driver);
    }

    public HabrSandboxPage open() {
        driver.get(URL);
        return this;
    }

    public void checkTitleSandboxPage(String titleText) {
        assertEquals(driver.findElement(titleSandboxPage).getText(), titleText, "Title is not " + titleText);
    }

    public void checkEditor() {
        driver.findElement(editor).isDisplayed();
    }
}
