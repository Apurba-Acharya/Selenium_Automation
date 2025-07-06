package ex05_XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class P4_XPathAxes {
    @Test
    public void XPathAxes(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        driver.findElement(By.xpath("//div[@class=\"form-group\"][3]//parent::form")); // Parent

        driver.findElement(By.xpath("//form[@class=\"form-horizontal\"]//child::div[3]")); // child

        driver.findElement(By.xpath("//form[@class=\"form-horizontal\"]//descendant::label[3][@for=\"txt-password\"]")); // Descendant

        driver.findElement(By.xpath("//label[@for=\"txt-password\"]//ancestor::form")); // Ancestor
        // Or, Ancestor : //label[@for="txt-password"]//ancestor::*

        driver.findElement(By.xpath("//form[@class=\"form-horizontal\"]//descendant::input[2]")); // Descendant





    }
}
