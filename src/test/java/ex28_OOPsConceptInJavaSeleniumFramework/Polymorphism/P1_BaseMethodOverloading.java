package ex28_OOPsConceptInJavaSeleniumFramework.Polymorphism;


/* -> Polymorphism: Is allow us to perform a task in many ways.
   -> Method Overloading /Static Binding/Compile Time Polymorphism/Early Binding: A class having
      multiple methods in the same name but different parameter is called as Method Overloading.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_BaseMethodOverloading {
    WebDriver driver;

    public P1_BaseMethodOverloading(WebDriver driver) {
        this.driver = driver;
    }
    // 1. Simple click
    public void action(By locator) {
        driver.findElement(locator).click();
    }
    // 2. Type text
    public void action(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }
    // 3. Type + Enter
    public void action(By locator, String value, boolean hitEnter) {
        WebElement el = driver.findElement(locator);
        el.sendKeys(value);
        if (hitEnter) { // both are same =>> hitEnter==true
            el.sendKeys(Keys.ENTER);
        }
    }
}
