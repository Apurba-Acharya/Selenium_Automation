package ex29_OOPsConceptInJavaSeleniumFramework.Abstraction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

    /*Abstraction: Abstraction means showing only essential details and hiding the background logic.
    -> Selenium WebDriver itself uses abstraction through interfaces (like WebDriver, WebElement). */

public class BaseTest {
    WebDriver driver;
    public void openBrowser(String browserName) throws InterruptedException {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser name!");
            return;
        }
        driver.get("https://www.google.com");
        Thread.sleep(5000);
    }
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

