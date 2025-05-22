package ex02_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class P3_Assertion {
    @Test
    public void selenium01 (){
        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");
        Assert.assertEquals(driver.getTitle(),"google");
    }
}
