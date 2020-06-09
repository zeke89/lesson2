package com.zeke.lesson2;

import com.zeke.lesson2.pages.HabrMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringApp {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApp.class, args);
        HabrMainPage habrMainPage = context.getBean(HabrMainPage.class);
    }

    @Bean
    public ChromeDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}