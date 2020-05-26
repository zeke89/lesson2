package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalCabinetPage extends AbstractPage {

    private static final String URL = "https://otus.ru/lk/biography/personal/";

    private By addContact = By.xpath("//button[contains(@class, 'js-formset-add js-lk-cv-custom-select-add')]");
    private By inputContact1 = By.xpath("//input[@id = 'id_contact-0-value']");
    private By inputContact2 = By.xpath("//input[@id = 'id_contact-1-value']");
    private By selectContact = By.xpath("//div[contains(@class, 'input_straight-bottom-right')]");
    private By facebookContact = By.xpath("//button[@data-value = 'facebook'][0]");
    private By vkContact = By.xpath("//button[@data-value = 'vk'][0]");
    private By saveButton = By.xpath("//button[contains(@class, 'lk-cv-action-buttons__button_gray js-disable-on-submit')]");

    public PersonalCabinetPage(WebDriver driver) {
        super(driver);
    }

    public PersonalCabinetPage open() {
        driver.get(URL);
        return this;
    }

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
        driver.findElement(inputContact1).sendKeys(facebookContact);
    }

    public void enterVkContact(String vkContact) {
        driver.findElement(inputContact2).sendKeys(vkContact);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void checkFacebookContact(String facebookContact) {
        ExpectedConditions.attributeToBe(inputContact1, "value", facebookContact);
    }

    public void checkVkContact(String vkContact) {
        ExpectedConditions.attributeToBe(inputContact1, "value", vkContact);
    }
}
