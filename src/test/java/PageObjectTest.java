import org.testng.annotations.Test;
import pages.OtusMainPage;
import pages.PersonalCabinetPage;

public class PageObjectTest extends BaseTest {

    @Test
    public void checkPersonalCabinetTest() {
        /*
        Шаги теста:
- Открыть https://otus.ru
- Авторизоваться на сайте
- Войти в личный кабинет
- В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
- Нажать сохранить
- Открыть https://otus.ru в "чистом браузере"
- Авторизоваться на сайе
- Войти в личный кабинет
- Проверить, что в разделе "О себе" отображаются указанные ранее данные
         */
        OtusMainPage otusMainPage = new OtusMainPage(driver);
        otusMainPage.open();
        otusMainPage.clickLoginButton();
        otusMainPage.enterEmail();
        otusMainPage.enterPassword();
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

        //personalCabinetPage.addNewContact();
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
        otusMainPage2.enterEmail();
        otusMainPage2.enterPassword();
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

        personalCabinetPage.chooseCountrySelect("Россия");

//        personalCabinetPage2.checkFacebookContact("test1");
//        personalCabinetPage2.checkVkContact("test2");
    }
}
