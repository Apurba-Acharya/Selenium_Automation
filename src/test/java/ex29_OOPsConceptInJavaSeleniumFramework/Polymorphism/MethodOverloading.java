package ex29_OOPsConceptInJavaSeleniumFramework.Polymorphism;


/* -> Polymorphism: Is allow us to perform a task in many way.
   -> Method Overloading /Static Binding/Compile Time Polymorphism/Early Binding: A class having
      multiple methods in the same name but different parameter is called as Method Overloading.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MethodOverloading {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

//      Driver.manage().timeouts().ImplecitlyWait(Duration.OfSeconds(3)/OfHours(1)/OfMinutes(3)).

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofHours(1));

        driver.quit();
    }
}
