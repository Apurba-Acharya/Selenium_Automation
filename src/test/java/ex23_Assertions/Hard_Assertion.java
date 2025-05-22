package ex23_Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Hard_Assertion {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        Assert.assertTrue(driver.getTitle().equals("XYZ"));
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        element.sendKeys("MacBook");
        element.sendKeys(Keys.ENTER);
        driver.quit();
    }
}
