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

//        Hard Assertions:
//        1. Stops execution immediately when an assertion fails.
//        2. Subsequent steps will not be executed.
//        3. Typically used when the failure should block the test case.

        Assert.assertTrue(driver.getTitle().equals("XYZ"));
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        element.sendKeys("MacBook");
        element.sendKeys(Keys.ENTER);
        driver.quit();
    }
}
