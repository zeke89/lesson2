package com.zeke.lesson2.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import static org.testng.Assert.assertEquals;

@Component
public class HabrMainPage extends BasePage {

    private static final String URL = "https://habr.com/ru/";
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    private final By logo = By.xpath("//a[@class = 'logo']");
    private final By searchButton = By.xpath("//button[@id = 'search-form-btn']");
    private final By searchInput = By.xpath("//input[@id = 'search-form-field']");
    private final By articleTitle = By.xpath("//article[@class = 'post post_preview']/h2/a");
    private final By changeLangButton = By.xpath("//button[@class = 'btn btn_medium btn_navbar_lang js-show_lang_settings']");
    private final By englishLangButton = By.xpath("//label[@for = 'hl_langs_en']");
    private final By russianLangButton = By.xpath("//label[@for = 'hl_langs_ru']");
    private final By saveLangButton = By.xpath("//button[@type = 'submit']");
    private final By howToBecameAuthorButton = By.xpath("//a[@class = 'bmenu__conversion']");
    private final By articlesList = By.xpath("//h2[@class = 'post__title']");
    private final By loginButton = By.xpath("//a[@id = 'login']");
    private final By registerButton = By.xpath("//a[@class = 'btn btn_medium btn_navbar_registration']");
    private final By authUserMenuButton = By.xpath("//button[@class = 'btn btn_medium btn_navbar_user-dropdown']");
    private final By logoutButton = By.xpath("//a[contains(@href, 'logout')]");
    private final By profileButton = By.xpath("//a[contains(@href, 'profile')]");
    private final By writeTopicButton = By.xpath("//a[@class = 'btn btn_medium btn_navbar_write-topic']");

    public HabrMainPage(WebDriver driver) {
        super(driver);
    }

    public HabrMainPage open() {
        driver.get(URL);
        return this;
    }

    @Step("Проверка логотипа компании")
    public void checkLogo() {
        driver.findElement(logo).isDisplayed();
    }

    @Step("Нажание кнопки поиска")
    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
    }

    @Step("Ввод поиского запроса - [{q}]")
    public void enterSearchText(String q) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(q);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }

    @Step("Проверка статьи с именем - [{articleName}]")
    public void checkArticleTitle(String articleName) {
        assertEquals(driver.findElement(articleTitle).getText(), articleName, "Title is not " + articleName);
    }

    @Step("Нажатие на кнопку смены языка")
    public void clickChangeLangButton() {
        wait.until(ExpectedConditions.elementToBeClickable(changeLangButton));
        driver.findElement(changeLangButton).click();
    }

    @Step("Нажатие на кнопку английского языка")
    public void clickEnglishLangButton() {
        wait.until(ExpectedConditions.elementToBeClickable(englishLangButton));
        driver.findElement(englishLangButton).click();
    }

    @Step("Нажатие на кнопку русского языка")
    public void clickRussianLangButton() {
        wait.until(ExpectedConditions.elementToBeClickable(russianLangButton));
        driver.findElement(russianLangButton).click();
    }

    @Step("Нажатие на кнопку сохранения языка")
    public void clickSaveLangButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveLangButton));
        driver.findElement(saveLangButton).click();
    }

    @Step("Проверка языка сайта - [{lang}]")
    public void checkSiteLang(String lang) {
        wait.until(ExpectedConditions.elementToBeClickable(howToBecameAuthorButton));
        assertEquals(driver.getCurrentUrl(), URL, "Title is not " + URL);
    }

    @Step("")
    public void checkLangHowToBecameAuthorButton(String howToBecameAuthor) {
        wait.until(ExpectedConditions.elementToBeClickable(howToBecameAuthorButton));
        assertEquals(driver.findElement(howToBecameAuthorButton).getText(), howToBecameAuthor, "Title is not " + howToBecameAuthor);
    }

    @Step("")
    public HabrArticlePage clickArticle(int articleNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(articlesList));
        driver.findElements(articlesList).get(articleNumber - 1 ).click();
        return new HabrArticlePage(driver);
    }

    @Step("")
    public HabrLoginPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        return new HabrLoginPage(driver);
    }

    @Step("")
    public HabrRegisterPage clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        return new HabrRegisterPage(driver);
    }

    @Step("")
    public void checkLogin(boolean isLogin) {
        if (isLogin) {
            driver.findElement(authUserMenuButton).isDisplayed();
        } else {
            driver.findElement(loginButton).isDisplayed();
        }
    }

    @Step("")
    public void clickUserMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(authUserMenuButton));
        driver.findElement(authUserMenuButton).click();
    }

    @Step("")
    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }

    @Step("")
    public HabrProfilePage clickProfileButton() {
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        driver.findElement(profileButton).click();
        return new HabrProfilePage(driver);
    }

    @Step("")
    public HabrSandboxPage clickSandboxButton() {
        wait.until(ExpectedConditions.elementToBeClickable(writeTopicButton));
        driver.findElement(writeTopicButton).click();
        return new HabrSandboxPage(driver);
    }
}
