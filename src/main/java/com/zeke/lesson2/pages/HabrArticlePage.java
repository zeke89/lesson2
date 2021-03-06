package com.zeke.lesson2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.testng.Assert.assertEquals;

@Component
public class HabrArticlePage extends BasePage {

    private static final String URL = "https://habr.com/ru/company";
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    private final By commentsTitle = By.xpath("//h2[@class = 'comments-section__head-title']");

    @Autowired
    public HabrArticlePage(WebDriver driver) {
        super(driver);
    }

    public HabrArticlePage open() {
        driver.get(URL);
        return this;
    }

    public void checkCommentsTitle(String commentsTitleText) {
        assertEquals((driver.findElement(commentsTitle).getText()).substring(0,11), commentsTitleText, "Title is not " + commentsTitleText);
    }
}
