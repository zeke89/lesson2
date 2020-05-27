import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.OtusMainPage;
import pages.PersonalCabinetPage;

import java.util.concurrent.TimeUnit;

//@Listeners(ExecutionListener.class)
public class OtusAuthTest extends BaseTest {

    protected static WebDriver driver;
    //private Logger logger = LogManager.getLogger(SampleTest.class);

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //logger.info("Драйвер поднят");
    }

    @Test
    public void OtusAuthTest() {

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

        personalCabinetPage.addNewContact();
        personalCabinetPage.openSelectContact();
        personalCabinetPage.chooseFacebookContact();
        personalCabinetPage.enterFacebookContact("test1");
        personalCabinetPage.addNewContact();
        personalCabinetPage.openSelectContact();
        personalCabinetPage.chooseVkContact();
        personalCabinetPage.enterVkContact("test2");
        personalCabinetPage.clickSaveButton();

        personalCabinetPage.chooseGender();
        personalCabinetPage.addCompany("РУ КВАД КОД");
        personalCabinetPage.addWork("QA engineer");



        //stop();

        OtusMainPage otusMainPage2 = new OtusMainPage(driver);
        otusMainPage2.open().clickLoginButton();
        otusMainPage2.enterEmail();
        otusMainPage2.enterPassword();
        otusMainPage2.clickSubmitLogin();
        otusMainPage2.clickPersonalLink();

        PersonalCabinetPage personalCabinetPage2 = new PersonalCabinetPage(driver);
        personalCabinetPage2.checkFacebookContact("test1");
        personalCabinetPage2.checkVkContact("test2");
    }
}
