package com.zeke.lesson2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import static org.testng.Assert.assertEquals;

@Component
public class HabrLoginPage extends BasePage {

    private static final String URL = "https://account.habr.com/login";
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 50, 1000);

    private final By emailInput = By.xpath("//input[@id = 'email_field']");
    private final By passwordInput = By.xpath("//input[@id = 'password_field']");
    private final By submitButton = By.xpath("//button[@name = 'go']");
    private final By titleLoginPage = By.xpath("//div[@class = 'shadow-box__title']");
    private final By errorLoginMessage = By.xpath("//div[@class = 'notice__text']");

    public HabrLoginPage(WebDriver driver) {
        super(driver);
    }

    public HabrLoginPage open() {
        driver.get(URL);
        return this;
    }

    public void checkTitleLoginPage(String titleText) {
        assertEquals(driver.findElement(titleLoginPage).getText(), titleText, "Title is not " + titleText);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public HabrMainPage clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        driver.findElement(submitButton).click();
        return new HabrMainPage(driver);
    }

    public void checkErrorLoginPage(String errorLoginMessageText) {
        assertEquals(driver.findElement(errorLoginMessage).getText(), errorLoginMessageText, "Error is not " + errorLoginMessageText);
    }
}
