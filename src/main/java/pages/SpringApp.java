package pages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApp.class, args);
        String result = (String)context.getBean("myBean");
        System.out.println(result);

        HabrMainPage habrMainPage = context.getBean(HabrMainPage.class);

//        HabrTests myDefault = context.getBean(HabrTests.class);
//        System.out.println(myDefault.getName());
//
//        MyInterface myTest = context.getBean("test", MyInterface.class);
//        System.out.println(myTest.getName());

    }

    @Bean
    public String myBean(){
        return "My name is myBean";
    }
}