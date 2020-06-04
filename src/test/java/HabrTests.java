import org.testng.annotations.Test;
import pages.*;

public class HabrTests extends BaseTest {

    @Test     //test1
    public void checkOpenMainPage() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        habrMainPage.checkLogo();
    }

    @Test     //test2
    public void checkArticleSearch() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        habrMainPage.clickSearchButton();
        habrMainPage.enterSearchText("quadcode");
        habrMainPage.checkArticleTitle("Digital-мероприятия в Санкт-Петербурге c 16 по 22 марта");
    }

    @Test     //test3
    public void checkChangeLang() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        habrMainPage.clickChangeLangButton();
        habrMainPage.clickEnglishLangButton();
        habrMainPage.clickSaveLangButton();
        habrMainPage.checkSiteLang("en");
        habrMainPage.checkLangHowToBecameAuthorButton("HOW TO BECOME AN AUTHOR");
    }

    @Test     //test4
    public void checkOpenArticlePage() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrArticlePage habrArticlePage = habrMainPage.clickArticle(1);
        habrArticlePage.checkCommentsTitle("Комментарии");
    }

    @Test     //test5
    public void checkOpenLoginPage() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrLoginPage habrLoginPage = habrMainPage.clickLoginButton();
        habrLoginPage.checkTitleLoginPage("Вход");
    }

    @Test     //test6
    public void checkLogin() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrLoginPage habrLoginPage = habrMainPage.clickLoginButton();
        habrLoginPage.enterEmail("golubcov.e@gmail.com");
        habrLoginPage.enterPassword("g0lubc0v");
        HabrMainPage habrMainPage1 = habrLoginPage.clickSubmitButton();
        habrMainPage1.checkLogin(true);
    }

    @Test     //test7
    public void checkErrorLogin() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrLoginPage habrLoginPage = habrMainPage.clickLoginButton();
        habrLoginPage.enterEmail("golubcov.e@gmail.com");
        habrLoginPage.enterPassword("g0lubc");
        habrLoginPage.clickSubmitButton();
        habrLoginPage.checkErrorLoginPage("Пользователь с такой электронной почтой или паролем не найден");
    }

    @Test     //test8
    public void checkLogout() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrLoginPage habrLoginPage = habrMainPage.clickLoginButton();
        habrLoginPage.enterEmail("golubcov.e@gmail.com");
        habrLoginPage.enterPassword("g0lubc0v");
        HabrMainPage habrMainPage1 = habrLoginPage.clickSubmitButton();
        habrMainPage1.checkLogin(true);
        habrMainPage1.clickUserMenuButton();
        habrMainPage1.clickLogoutButton();
        habrMainPage1.checkLogin(false);
    }

    @Test     //test9
    public void checkOpenProfilePage() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrLoginPage habrLoginPage = habrMainPage.clickLoginButton();
        habrLoginPage.enterEmail("golubcov.e@gmail.com");
        habrLoginPage.enterPassword("g0lubc0v");
        HabrMainPage habrMainPage1 = habrLoginPage.clickSubmitButton();
        habrMainPage1.checkLogin(true);
        habrMainPage1.clickUserMenuButton();
        HabrProfilePage habrProfilePage = habrMainPage1.clickProfileButton();
        habrProfilePage.checkTitleLoginPage("Настройки профиля");
    }

    @Test     //test10
    public void checkFio() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrLoginPage habrLoginPage = habrMainPage.clickLoginButton();
        habrLoginPage.enterEmail("golubcov.e@gmail.com");
        habrLoginPage.enterPassword("g0lubc0v");
        HabrMainPage habrMainPage1 = habrLoginPage.clickSubmitButton();
        habrMainPage1.checkLogin(true);
        habrMainPage1.clickUserMenuButton();
        HabrProfilePage habrProfilePage = habrMainPage1.clickProfileButton();
        habrProfilePage.checkFio("Голубцов Евгений Сергеевич");
    }

    @Test     //test11
    public void checkOpenSandboxPage() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrLoginPage habrLoginPage = habrMainPage.clickLoginButton();
        habrLoginPage.enterEmail("golubcov.e@gmail.com");
        habrLoginPage.enterPassword("g0lubc0v");
        HabrMainPage habrMainPage1 = habrLoginPage.clickSubmitButton();
        habrMainPage1.checkLogin(true);
        HabrSandboxPage habrSandboxPage = habrMainPage1.clickSandboxButton();
        habrSandboxPage.checkTitleSandboxPage("Публикация, претендующая на приглашение");
    }

    @Test     //test12
    public void checkEditorOnSandboxPage() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrLoginPage habrLoginPage = habrMainPage.clickLoginButton();
        habrLoginPage.enterEmail("golubcov.e@gmail.com");
        habrLoginPage.enterPassword("g0lubc0v");
        HabrMainPage habrMainPage1 = habrLoginPage.clickSubmitButton();
        habrMainPage1.checkLogin(true);
        HabrSandboxPage habrSandboxPage = habrMainPage1.clickSandboxButton();
        habrSandboxPage.checkEditor();
    }

    @Test     //test13
    public void checkOpenRegisterPage() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrRegisterPage habrRegisterPage = habrMainPage.clickRegisterButton();
        habrRegisterPage.checkTitleRegisterPage("Регистрация");
    }

    @Test     //test14
    public void checkRegister() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrRegisterPage habrRegisterPage = habrMainPage.clickRegisterButton();
        habrRegisterPage.enterEmail("golubcov.e+test1@gmail.com");
        habrRegisterPage.enterNick("zeke123454");
        habrRegisterPage.enterPassword("qwerty123");
        habrRegisterPage.enterRepeatPassword("qwerty123");
        HabrMainPage habrMainPage1 = habrRegisterPage.clickSubmitButton();
        habrMainPage1.checkLogin(true);
    }

    @Test     //test15
    public void checkRegisterWithExistEmail() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrRegisterPage habrRegisterPage = habrMainPage.clickRegisterButton();
        habrRegisterPage.enterEmail("golubcov.e+test1@gmail.com");
        habrRegisterPage.enterNick("zeke123454");
        habrRegisterPage.enterPassword("qwerty123");
        habrRegisterPage.enterRepeatPassword("qwerty123");
        habrRegisterPage.clickSubmitButton();
        habrRegisterPage.checkErrorRegisterPage("Такой пользователь уже зарегистрирован");
    }
}