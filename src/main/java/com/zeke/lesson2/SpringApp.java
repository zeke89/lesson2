package com.zeke.lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.zeke.lesson2.pages.HabrMainPage;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringApp {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApp.class, args);
//        String result = (String)context.getBean("myBean");
//        System.out.println(result);

        HabrMainPage habrMainPage = context.getBean(HabrMainPage.class);

        //HabrTests myDefault = context.getBean(HabrTests.class);
//        System.out.println(myDefault.getName());
//
//        MyInterface myTest = context.getBean("test", MyInterface.class);
//        System.out.println(myTest.getName());

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