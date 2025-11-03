package ex29_OOPsConceptInJavaSeleniumFramework.Inheritance;


/*Inheritance means one child class can use the properties and methods of another class
  (parent) — without rewriting them. */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Browser opened and maximized.");
    }
    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser closed.");
    }
}

class GoogleTest extends BaseTest {
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Opened Google homepage.");
    }

    public static void main(String[] args) {
        GoogleTest test = new GoogleTest();
        test.openBrowser();   // Inherited from BaseTest
        test.openGoogle();    // Defined in child class
        test.closeBrowser();  // Inherited from BaseTest
    }
}