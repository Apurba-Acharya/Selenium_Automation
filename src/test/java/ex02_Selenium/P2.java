package ex02_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class P2 {
    @Test
    public void selenium01 (){

        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        //To full screen the browser >>
        driver.manage().window().maximize();

    }
}
