package com.zeke.lesson2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import static org.testng.Assert.assertEquals;

@Component
public class HabrRegisterPage extends BasePage {

    private static final String URL = "https://account.habr.com/register";
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    private final By emailInput = By.xpath("//input[@id = 'email_field']");
    private final By nickInput = By.xpath("//input[@id = 'nickname_field']");
    private final By passwordInput = By.xpath("//input[@id = 'password_field']");
    private final By passwordRepeatInput = By.xpath("//input[@id = 'password_repeat']");
    private final By submitButton = By.xpath("//button[@name = 'go']");
    private final By titleRegisterPage = By.xpath("//div[@class = 'shadow-box__title']");
    private final By errorMessage = By.xpath("//div[@class = 's-error']");

    public HabrRegisterPage(WebDriver driver) {
        super(driver);
    }

    public HabrRegisterPage open() {
        driver.get(URL);
        return this;
    }

    public void checkTitleRegisterPage(String titleText) {
        assertEquals(driver.findElement(titleRegisterPage).getText(), titleText, "Title is not " + titleText);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterNick(String nick) {
        driver.findElement(nickInput).clear();
        driver.findElement(nickInput).sendKeys(nick);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterRepeatPassword(String repeatPassword) {
        driver.findElement(passwordRepeatInput).clear();
        driver.findElement(passwordRepeatInput).sendKeys(repeatPassword);
    }

    public HabrMainPage clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        driver.findElement(submitButton).click();
        return new HabrMainPage(driver);
    }

    public void checkErrorRegisterPage(String errorMessageText) {
        assertEquals(driver.findElement(errorMessage).getText(), errorMessageText, "Error is not " + errorMessageText);
    }
}
