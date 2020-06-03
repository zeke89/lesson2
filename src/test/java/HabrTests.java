import org.testng.annotations.Test;
import pages.HabrArticlePage;
import pages.HabrMainPage;

public class HabrTests extends BaseTest {

    @Test
    public void checkOpenMainPage() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        habrMainPage.checkLogo();
    }

    @Test
    public void checkArticleSearch() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        habrMainPage.clickSearchButton();
        habrMainPage.enterSearchText("quadcode");
        habrMainPage.checkArticleTitle("Digital-мероприятия в Санкт-Петербурге c 16 по 22 марта");
    }

    @Test
    public void checkChangeLang() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        habrMainPage.clickChangeLangButton();
        habrMainPage.clickRussianLangButton();
        habrMainPage.clickSaveLangButton();
        habrMainPage.checkSiteLang("ru");
        habrMainPage.checkLangHowToBecameAuthorButton("КАК СТАТЬ АВТОРОМ");
    }

    @Test
    public void checkOpenArticlePage() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        HabrArticlePage habrArticlePage = habrMainPage.clickArticle(2);
        habrArticlePage.checkCommentsTitle("Comments 0");
    }
}
