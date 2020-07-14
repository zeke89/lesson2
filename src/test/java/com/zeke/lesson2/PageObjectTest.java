package com.zeke.lesson2;

import com.zeke.lesson2.pages.OtusMainPage;
import com.zeke.lesson2.pages.PersonalCabinetPage;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class PageObjectTest extends BaseTest {

    @Test
    public void checkPersonalCabinetTest() throws MalformedURLException {
        OtusMainPage otusMainPage = new OtusMainPage(driver);
        otusMainPage.open();
        otusMainPage.clickLoginButton();
        otusMainPage.enterEmail("test@test.ru");
        otusMainPage.enterPassword("qwerty");
        otusMainPage.clickSubmitLogin();
        otusMainPage.openMenu();
        otusMainPage.clickPersonalLink();

        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver);

        personalCabinetPage.addFirstName("Евгений");
        personalCabinetPage.addLastName("Голубцов");
        personalCabinetPage.addFirstNameLatin("Eugene");
        personalCabinetPage.addLastNameLatin("Golubcov");
        personalCabinetPage.addBlogName("zeke");
        personalCabinetPage.addDateOfBirth("29.12.1989");

        personalCabinetPage.chooseCountrySelect();
        personalCabinetPage.chooseCitySelect();
        personalCabinetPage.chooseEnglishLevel();
        personalCabinetPage.chooseRelocated();
        personalCabinetPage.chooseAlignment();

        personalCabinetPage.openSelectFirstContact();
        personalCabinetPage.chooseFacebookContact();
        personalCabinetPage.enterFacebookContact("test1");
        personalCabinetPage.addNewContact();
        personalCabinetPage.openSelectSecondContact();
        personalCabinetPage.chooseVkContact();
        personalCabinetPage.enterVkContact("test2");

        personalCabinetPage.chooseGender();
        personalCabinetPage.addCompany("РУ КВАД КОД");
        personalCabinetPage.addWork("QA engineer");
        personalCabinetPage.clickAddExperience();
        personalCabinetPage.chooseExperienceLang();
        personalCabinetPage.chooseExperienceLevel();

        personalCabinetPage.clickSaveButton();
        personalCabinetPage.checkSuccessMessage();

        stopBrowser();
        startBrowser();

        OtusMainPage otusMainPage2 = new OtusMainPage(driver);
        otusMainPage2.open();
        otusMainPage2.clickLoginButton();
        otusMainPage2.enterEmail("test@test.ru");
        otusMainPage2.enterPassword("qwerty");
        otusMainPage2.clickSubmitLogin();
        otusMainPage2.openMenu();
        otusMainPage2.clickPersonalLink();


        PersonalCabinetPage personalCabinetPage2 = new PersonalCabinetPage(driver);
        personalCabinetPage2.checkFirstNameInput("Евгений");
        personalCabinetPage2.checkLastNameInput("Голубцов");
        personalCabinetPage2.checkFirstNameLatinInput("Eugene");
        personalCabinetPage2.checkLastNameLatinInput("Golubcov");
        personalCabinetPage2.checkBlogNameInput("zeke");
        personalCabinetPage2.checkDateOfBirthInput("29.12.1989");

        personalCabinetPage2.checkCountrySelect("Россия");
        personalCabinetPage2.checkCitySelect("Санкт-Петербург");
        personalCabinetPage2.checkEnglishLevel("Средний (Intermediate)");
        personalCabinetPage2.checkAlignment("Полный день");

        personalCabinetPage2.checkFacebookContact("test1");
        personalCabinetPage2.checkVkContact("test2");

        personalCabinetPage2.checkGenderSelect("Мужской");
        personalCabinetPage2.checkCompanyNameInput("РУ КВАД КОД");
        personalCabinetPage2.checkWorkNameInput("QA engineer");

        personalCabinetPage2.checkExperienceLangSelect("Java");
        personalCabinetPage2.checkExperienceLevelSelect("1 год");
    }
}
