package ex02_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class P4 {
    @Test
    public void selenium01 () throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        if (driver.getPageSource().contains("CURA Healthcare Service")){
            System.out.println("visible");
            Assert.assertTrue(true);
        } else{
            throw new Exception("not visible");
        }
    }
}
