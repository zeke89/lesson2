package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OtusMainPage extends BasePage {

    private static final String URL = "https://otus.ru";

    private By loginButton = By.xpath("//button[@data-modal-id='new-log-reg']");
    private By emailInput = By.xpath("//div[@class='new-log-reg__body']//input[@name='email']");
    private By passwordInput = By.xpath("//div[@class='new-log-reg__body']//input[@name='password']");

    private WebElement loginSubmitButton = driver.findElement(By.xpath("//div[@class='new-log-reg__body']//button[@type = 'submit']"));
    //private By loginSubmitButton = By.xpath("//div[@class='new-log-reg__body']//button[@type = 'submit']");
    private By menuButton = By.xpath("//div[@class = 'header2-menu__item-wrapper header2-menu__item-wrapper__username']");
    private By personalCabinet = By.xpath("//div[@class = 'header2-menu__dropdown-text']");

    public OtusMainPage(WebDriver driver){
        super(driver);
    }

    public OtusMainPage open() {
        driver.get(URL);
        return this;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void enterEmail() {
        driver.findElement(emailInput).sendKeys("evgenii.golubcov@iqoption.com");
    }

    public void enterPassword() {
        driver.findElement(passwordInput).sendKeys("C506ma17*");
    }

    public void clickSubmitLogin() {
        loginSubmitButton.click();
    }

    public void openMenu() {
        Actions action = new Actions(driver);
        action.moveToElement((WebElement) menuButton);
        action.perform();
    }

    public void clickPersonalLink() {
        driver.findElement(personalCabinet).click();
    }
}