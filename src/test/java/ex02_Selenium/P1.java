package ex02_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class P1 {
    @Test
    public void selenium01 (){
        WebDriver driver;
        // 2  Do you want to run on Chrome then change to Edge ?
        driver = new ChromeDriver();
        driver = new EdgeDriver();// 97% -
        driver = new FirefoxDriver(); // 97% -
    }

}
