package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class HabrMainPage extends BasePage {

    private static final String URL = "https://habr.com/";
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    private By logo = By.xpath("//a[@class = 'logo']");
    private By searchButton = By.xpath("//button[@id = 'search-form-btn']");
    private By searchInput = By.xpath("//input[@id = 'search-form-field']");
    private By articleTitle = By.xpath("//article[@class = 'post post_preview']/h2/a");
    private By changeLangButton = By.xpath("//button[@class = 'btn btn_medium btn_navbar_lang js-show_lang_settings']");
    private By englishLangButton = By.xpath("//label[@for = 'hl_langs_en']");
    private By russianLangButton = By.xpath("//label[@for = 'hl_langs_ru']");
    private By saveLangButton = By.xpath("//button[@type = 'submit']");
    private By howToBecameAuthorButton = By.xpath("//a[@class = 'bmenu__conversion']");
    private By articlesList = By.xpath("//h2[@class = 'post__title']");

    public HabrMainPage(WebDriver driver) {
        super(driver);
    }

    public HabrMainPage open() {
        driver.get(URL);
        return this;
    }

    public void checkLogo() {
        driver.findElement(logo).isDisplayed();
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
    }

    public void enterSearchText(String q) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(q);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }

    public void checkArticleTitle(String articleName) {
        assertEquals(driver.findElement(articleTitle).getText(), articleName, "Title is not " + articleName);
    }

    public void clickChangeLangButton() {
        wait.until(ExpectedConditions.elementToBeClickable(changeLangButton));
        driver.findElement(changeLangButton).click();
    }

    public void clickEnglishLangButton() {
        wait.until(ExpectedConditions.elementToBeClickable(englishLangButton));
        driver.findElement(englishLangButton).click();
    }

    public void clickRussianLangButton() {
        wait.until(ExpectedConditions.elementToBeClickable(russianLangButton));
        driver.findElement(russianLangButton).click();
    }

    public void clickSaveLangButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveLangButton));
        driver.findElement(saveLangButton).click();
    }

    public void checkSiteLang(String lang) {
        wait.until(ExpectedConditions.elementToBeClickable(howToBecameAuthorButton));
        assertEquals(driver.getCurrentUrl(), URL+lang+"/", "Title is not " + URL+lang+"/");
    }

    public void checkLangHowToBecameAuthorButton(String howToBecameAuthor) {
        assertEquals(driver.findElement(howToBecameAuthorButton).getText(), howToBecameAuthor, "Title is not " + howToBecameAuthor);
    }

    public HabrArticlePage clickArticle(int articleNumber) {
        driver.findElements(articlesList).get(articleNumber - 1 ).click();
        return new HabrArticlePage(driver);
    }
}
