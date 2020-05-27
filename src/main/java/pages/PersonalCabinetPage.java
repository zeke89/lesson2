package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalCabinetPage extends BasePage {

    private static final String URL = "https://otus.ru/lk/biography/personal/";

    private By firstNameInput = By.xpath("//input[@name = 'fname']");
    private By firstNameLatinInput = By.xpath("//input[@name = 'fname_latin']");
    private By lastNameInput = By.xpath("//input[@name = 'lname']");
    private By lastNameLatinInput = By.xpath("//input[@name = 'lname_latin']");
    private By blogNameInput = By.xpath("//input[@name = 'blogname']");
    private By dateOfBirthInput = By.xpath("//input[@name = 'date_of_birth']");

    private By countrySelect = By.xpath("//input[@name = 'country']/following-sibling::div");//data-selected-option-class="lk-cv-block__select-option_selected
    private By countrySelectValue = By.xpath("//button[@title = 'Россия']");
    private By citySelect = By.xpath("//input[@name = 'city']/following-sibling::div");
    private By citySelectValue = By.xpath("//button[@title = 'Санкт-Петербург']");
    private By englishLevelSelect = By.xpath("//input[@name = 'english_level']/following-sibling::div");
    private By englishLevelSelectValue = By.xpath("//button[@title = 'Средний (Intermediate)']");
    private By relocatedRadioButton = By.xpath("//input[@id = 'id_ready_to_relocate_0']/ancestor::label");
    private By alignmentCheckbox = By.xpath("//input[@title = 'Полный день']/ancestor::label");

    private By addContact = By.xpath("//button[contains(@class, 'js-formset-add js-lk-cv-custom-select-add')]");
    private By facebookInput = By.xpath("//input[@id = 'id_contact-0-value']");
    private By vkInput = By.xpath("//input[@id = 'id_contact-1-value']");
    private By selectContact = By.xpath("//div[contains(@class, 'input_straight-bottom-right')]");
    private By facebookContact = By.xpath("//button[@data-value = 'facebook'][0]");
    private By vkContact = By.xpath("//button[@data-value = 'vk'][0]");

    private By genderSelect = By.xpath("//select[@id = 'id_gender']");
    private By genderSelectValue = By.xpath("//option[text() = 'Мужской']");
    private By companyNameInput = By.xpath("//input[@id = 'id_company']");

    private By saveButton = By.xpath("//button[contains(@class, 'lk-cv-action-buttons__button_gray js-disable-on-submit')]");


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

    //Nain info

    public void chooseCountrySelect() {
        driver.findElement(countrySelect).click();
        driver.findElement(countrySelectValue).click();
    }

    public void chooseCitySelect() {
        driver.findElement(citySelect).click();
        driver.findElement(citySelectValue).click();
    }

    public void chooseEnglishLevel() {
        driver.findElement(englishLevelSelect).click();
        driver.findElement(englishLevelSelectValue).click();
    }

    public void chooseRelocated() {
        driver.findElement(relocatedRadioButton).click();
    }

    public void chooseAlignment() {
        driver.findElement(alignmentCheckbox).click();
    }

    //Contact info

    public void addNewContact() {
        driver.findElement(addContact).click();
    }

    public void openSelectContact() {
        driver.findElement(selectContact).click();
    }

    public void chooseFacebookContact() {
        driver.findElement(facebookContact).click();
    }

    public void chooseVkContact() {
        driver.findElement(vkContact).click();
    }

    public void enterFacebookContact(String facebookContact) {
        driver.findElement(facebookInput).sendKeys(facebookContact);
    }

    public void enterVkContact(String vkContact) {
        driver.findElement(vkInput).sendKeys(vkContact);
    }

    // Other

    public void chooseGender() {
        driver.findElement(genderSelect).click();
        driver.findElement(genderSelectValue).click();
    }

    public void addCompany(String companyName) {
        driver.findElement(companyNameInput).clear();
        driver.findElement(companyNameInput).sendKeys(companyName);
    }

    //Safe data

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    //Check Info

    public void checkFacebookContact(String facebookContact) {
        ExpectedConditions.attributeToBe(facebookInput, "value", facebookContact);
    }

    public void checkVkContact(String vkContact) {
        ExpectedConditions.attributeToBe(facebookInput, "value", vkContact);
    }
}