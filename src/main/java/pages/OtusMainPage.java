package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OtusMainPage extends BasePage {

    private static final String URL = "https://otus.ru";
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    private By loginButton = By.xpath("//button[@data-modal-id='new-log-reg']");
    private By emailInput = By.xpath("//div[@class='new-log-reg__body']//input[@name='email']");
    private By passwordInput = By.xpath("//div[@class='new-log-reg__body']//input[@name='password']");
    private By loginSubmitButton = By.xpath("//div[@class='new-log-reg__body']//button[@type = 'submit']");
    private By menuButton = By.xpath("//div[@class = 'header2-menu__item-wrapper header2-menu__item-wrapper__username']");
    private By personalCabinet = By.xpath("//div[@class = 'header2-menu__dropdown-text']");

    public OtusMainPage(WebDriver driver) {
        super(driver);
    }

    public OtusMainPage open() {
        driver.get(URL);
        return this;
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmitLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitButton));
        driver.findElement(loginSubmitButton).click();
    }

    public void openMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        driver.findElement(menuButton).click();
    }

    public void clickPersonalLink() {
        wait.until(ExpectedConditions.elementToBeClickable(personalCabinet));
        driver.findElement(personalCabinet).click();
    }
}