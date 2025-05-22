package ex02_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class P5_Navigation {
    @Test
    public void selenium01 () throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com/");

        //Types of navigation in Selenium:
        driver.navigate().to("https://bing.com");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
        Thread.sleep(5000);
        driver.navigate().refresh();
    }
}
