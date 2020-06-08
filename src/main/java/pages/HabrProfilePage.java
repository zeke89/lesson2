package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import static org.testng.Assert.assertEquals;

@Component
public class HabrProfilePage extends BasePage {

    private static final String URL = "https://habr.com/ru/auth/settings/profile/";
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    private final By fioInput = By.xpath("//input[@class = 'h-form-input__control']");
    private final By titleProfilePage = By.xpath("//h1[@class = 'h-page__title']");


    public HabrProfilePage(WebDriver driver) {
        super(driver);
    }

    public HabrProfilePage open() {
        driver.get(URL);
        return this;
    }

    public void checkTitleLoginPage(String titleText) {
        assertEquals(driver.findElement(titleProfilePage).getText(), titleText, "Title is not " + titleText);
    }

    public void checkFio(String fioText) {
        assertEquals(driver.findElements(fioInput).get(0).getText(), fioText, "Fio is not " + fioText);
    }
}
