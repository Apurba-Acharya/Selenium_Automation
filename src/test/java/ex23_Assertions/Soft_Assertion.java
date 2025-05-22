package ex23_Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class Soft_Assertion {
    public static void main(String[] args) throws InterruptedException {

        SoftAssert soft = new SoftAssert();

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();

        soft.assertTrue(driver.getTitle().equals("XYZ")); // SoftAssertions

        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        Thread.sleep(3000);
        element.sendKeys("MacBook");
        Thread.sleep(3000);
        element.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.quit();

        soft.assertAll(); //Print assertions in console.
    }
}
