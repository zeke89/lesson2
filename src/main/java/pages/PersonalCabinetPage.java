package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class PersonalCabinetPage extends BasePage {

    private static final String URL = "https://otus.ru/lk/biography/personal/";
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    private By firstNameInput = By.xpath("//input[@name = 'fname']");
    private By firstNameLatinInput = By.xpath("//input[@name = 'fname_latin']");
    private By lastNameInput = By.xpath("//input[@name = 'lname']");
    private By lastNameLatinInput = By.xpath("//input[@name = 'lname_latin']");
    private By blogNameInput = By.xpath("//input[@name = 'blog_name']");
    private By dateOfBirthInput = By.xpath("//input[@name = 'date_of_birth']");

    private By countrySelect = By.xpath("//input[@name = 'country']/../div");
    private By countrySelectValue = By.xpath("//button[@title = 'Россия']");
    private By citySelect = By.xpath("//input[@name = 'city']/following-sibling::div");
    private By citySelectValue = By.xpath("//button[@title = 'Санкт-Петербург']");
    private By englishLevelSelect = By.xpath("//input[@name = 'english_level']/../div");
    private By englishLevelSelectValue = By.xpath("//button[@title = 'Средний (Intermediate)']");
    private By relocatedRadioButton = By.xpath("//input[@id = 'id_ready_to_relocate_0']/ancestor::label");
    private By alignmentCheckbox = By.xpath("//input[@title = 'Полный день']/../span");

    private By addContact = By.xpath("//button[contains(@class, 'js-formset-add js-lk-cv-custom-select-add')]");
    private By facebookInput = By.xpath("//input[@id = 'id_contact-0-value']");
    private By vkInput = By.xpath("//input[@id = 'id_contact-1-value']");
    private By selectFirstContact = By.xpath("//input[@name='contact-0-service']/../div");
    private By selectSecondContact = By.xpath("//input[@name='contact-1-service']/../div");
    private By facebookContact = By.xpath("//input[@name='contact-0-service']/../../div/div/button[2]");
    private By vkContact = By.xpath("//input[@name='contact-1-service']/../../div/div/button[7]");

    private By genderSelect = By.xpath("//select[@id = 'id_gender']");
    private By genderSelectValue = By.xpath("//option[text() = 'Мужской']");
    private By companyNameInput = By.xpath("//input[@id = 'id_company']");
    private By workNameInput = By.xpath("//input[@id = 'id_work']");

    private By addExperienceLink = By.xpath("//a[@class= 'experience-add js-formset-add']");
    private By experienceLangSelect = By.xpath("//select[@id= 'id_experience-0-experience']");
    private By experienceLangSelectValue = By.xpath("//option[text() = 'Java']");
    private By experienceLevelSelect = By.xpath("//select[@id= 'id_experience-0-level']");
    private By experienceLevelSelectValue = By.xpath("//option[text() = '1 год']");

    private By saveButton = By.xpath("//button[contains(@class, 'lk-cv-action-buttons__button_gray js-disable-on-submit')]");
    private By messageNotification = By.xpath("//span[@class = 'messages']");


    public PersonalCabinetPage(WebDriver driver) {
        super(driver);
    }

    public PersonalCabinetPage open() {
        driver.get(URL);
        return this;
    }

    //Personal info

    public void addFirstName(String firstName) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void addLastName(String lastName) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void addFirstNameLatin(String firstNameLatin) {
        driver.findElement(firstNameLatinInput).clear();
        driver.findElement(firstNameLatinInput).sendKeys(firstNameLatin);
    }

    public void addLastNameLatin(String lastNameLatin) {
        driver.findElement(lastNameLatinInput).clear();
        driver.findElement(lastNameLatinInput).sendKeys(lastNameLatin);
    }

    public void addBlogName(String blogName) {
        driver.findElement(blogNameInput).clear();
        driver.findElement(blogNameInput).sendKeys(blogName);
    }

    public void addDateOfBirth(String dateOfBirth) {
        driver.findElement(dateOfBirthInput).clear();
        driver.findElement(dateOfBirthInput).sendKeys(dateOfBirth);
    }

    //Main info

    public void chooseCountrySelect() {
        wait.until(ExpectedConditions.elementToBeClickable(countrySelect));
        driver.findElement(countrySelect).click();
        wait.until(ExpectedConditions.elementToBeClickable(countrySelectValue));
        driver.findElement(countrySelectValue).click();
    }

    public void chooseCitySelect() {
        wait.until(ExpectedConditions.elementToBeClickable(citySelect));
        driver.findElement(citySelect).click();
        ExpectedConditions.elementToBeClickable(citySelectValue);
        driver.findElement(citySelectValue).click();
    }

    public void chooseEnglishLevel() {
        wait.until(ExpectedConditions.elementToBeClickable(englishLevelSelect));
        driver.findElement(englishLevelSelect).click();
        wait.until(ExpectedConditions.elementToBeClickable(englishLevelSelectValue));
        driver.findElement(englishLevelSelectValue).click();
    }

    public void chooseRelocated() {
        wait.until(ExpectedConditions.elementToBeClickable(relocatedRadioButton));
        driver.findElement(relocatedRadioButton).click();
    }

    public void chooseAlignment() {
        wait.until(ExpectedConditions.elementToBeClickable(alignmentCheckbox));
        driver.findElement(alignmentCheckbox).click();
    }

    //Contact info

    public void addNewContact() {
        wait.until(ExpectedConditions.elementToBeClickable(addContact));
        driver.findElement(addContact).click();
    }

    public void openSelectFirstContact() {
        wait.until(ExpectedConditions.elementToBeClickable(selectFirstContact));
        driver.findElement(selectFirstContact).click();
    }

    public void openSelectSecondContact() {
        wait.until(ExpectedConditions.elementToBeClickable(selectSecondContact));
        driver.findElement(selectSecondContact).click();
    }

    public void chooseFacebookContact() {
        wait.until(ExpectedConditions.elementToBeClickable(facebookContact));
        driver.findElement(facebookContact).click();
    }

    public void chooseVkContact() {
        wait.until(ExpectedConditions.elementToBeClickable(vkContact));
        driver.findElement(vkContact).click();
    }

    public void enterFacebookContact(String facebookContact) {
        wait.until(ExpectedConditions.elementToBeClickable(facebookInput));
        driver.findElement(facebookInput).sendKeys(facebookContact);
    }

    public void enterVkContact(String vkContact) {
        wait.until(ExpectedConditions.elementToBeClickable(vkInput));
        driver.findElement(vkInput).sendKeys(vkContact);
    }

    // Other

    public void chooseGender() {
        wait.until(ExpectedConditions.elementToBeClickable(genderSelect));
        driver.findElement(genderSelect).click();
        wait.until(ExpectedConditions.elementToBeClickable(genderSelectValue));
        driver.findElement(genderSelectValue).click();
    }

    public void addCompany(String companyName) {
        wait.until(ExpectedConditions.elementToBeClickable(companyNameInput));
        driver.findElement(companyNameInput).clear();
        driver.findElement(companyNameInput).sendKeys(companyName);
    }

    public void addWork(String workName) {
        wait.until(ExpectedConditions.elementToBeClickable(workNameInput));
        driver.findElement(workNameInput).clear();
        driver.findElement(workNameInput).sendKeys(workName);
    }

    //Experience

    public void clickAddExperience() {
        wait.until(ExpectedConditions.elementToBeClickable(addExperienceLink));
        driver.findElement(addExperienceLink).click();
    }

    public void chooseExperienceLang() {
        wait.until(ExpectedConditions.elementToBeClickable(experienceLangSelect));
        driver.findElement(experienceLangSelect).click();
        wait.until(ExpectedConditions.elementToBeClickable(experienceLangSelectValue));
        driver.findElement(experienceLangSelectValue).click();
    }

    public void chooseExperienceLevel() {
        wait.until(ExpectedConditions.elementToBeClickable(experienceLevelSelect));
        driver.findElement(experienceLevelSelect).click();
        wait.until(ExpectedConditions.elementToBeClickable(experienceLevelSelectValue));
        driver.findElement(experienceLevelSelectValue).click();
    }

    //Safe data

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(saveButton).click();
    }

    public void checkSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageNotification));
        driver.findElement(messageNotification);
    }

    public String getValueTextField(WebElement webElement){
        return webElement.getAttribute("value");
    }

    public String getInnerTextTextField(WebElement webElement){
        return webElement.getAttribute("innerText");
    }

    public String getValueCheckField(WebElement webElement){
        return webElement.getAttribute("checked");
    }

    //Check Personal Info

    public void checkFirstNameInput(String firstName) {
        assertEquals(getValueTextField(driver.findElement(firstNameInput)), firstName, "First name not equal " + firstName);
    }

    public void checkLastNameInput(String lastName) {
        assertEquals(getValueTextField(driver.findElement(lastNameInput)), lastName, "Last name not equal " + lastName);
    }

    public void checkFirstNameLatinInput(String firstNameLatin) {
        assertEquals(getValueTextField(driver.findElement(firstNameLatinInput)), firstNameLatin, "First name latin not equal " + firstNameLatin);
    }

    public void checkLastNameLatinInput(String lastNameLatin) {
        assertEquals(getValueTextField(driver.findElement(lastNameLatinInput)), lastNameLatin, "Last name latin not equal " + lastNameLatin);
    }

    public void checkBlogNameInput(String blogName) {
        assertEquals(getValueTextField(driver.findElement(blogNameInput)), blogName, "Blog name not equal " + blogName);
    }

    public void checkDateOfBirthInput(String dateOfBirth) {
        assertEquals(getValueTextField(driver.findElement(dateOfBirthInput)), dateOfBirth, "Date of birth not equal " + dateOfBirth);
    }

    //Check Main Info

    public void chooseCountrySelect(String countrySelectVal) {
        assertEquals(getInnerTextTextField(driver.findElement(countrySelectValue)), countrySelectVal, "Country not equal " + countrySelectVal);
    }

//    public void chooseCitySelect() {
//        wait.until(ExpectedConditions.elementToBeClickable(citySelect));
//        driver.findElement(citySelect).click();
//        ExpectedConditions.elementToBeClickable(citySelectValue);
//        driver.findElement(citySelectValue).click();
//    }
//
//    public void chooseEnglishLevel() {
//        wait.until(ExpectedConditions.elementToBeClickable(englishLevelSelect));
//        driver.findElement(englishLevelSelect).click();
//        wait.until(ExpectedConditions.elementToBeClickable(englishLevelSelectValue));
//        driver.findElement(englishLevelSelectValue).click();
//    }
//
//    public void chooseRelocated() {
//        wait.until(ExpectedConditions.elementToBeClickable(relocatedRadioButton));
//        driver.findElement(relocatedRadioButton).click();
//    }
//
//    public void chooseAlignment() {
//        wait.until(ExpectedConditions.elementToBeClickable(alignmentCheckbox));
//        driver.findElement(alignmentCheckbox).click();
//    }


//    public void checkFacebookContact(String facebookContact) {
//        assertEquals(facebookContact, driver.findElement(facebookInput).getText(), "Facebook nike not equal " + facebookContact);
//    }
//
//    public void checkVkContact(String vkContact) {
//        assertEquals(vkContact, driver.findElement(vkInput).getText(), "Vk nike not equal " + facebookContact);
//    }
}