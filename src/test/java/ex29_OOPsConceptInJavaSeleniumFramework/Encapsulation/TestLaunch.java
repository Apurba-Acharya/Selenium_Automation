package ex29_OOPsConceptInJavaSeleniumFramework.Encapsulation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLaunch {
    public static void main(String[] args) {
        BrowserConfig config = new BrowserConfig();
        config.setBrowserName("chrome");
        WebDriver driver = null;
        if (config.getBrowserName().equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (config.getBrowserName().equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get("https://www.OrangeHRM.com");
        driver.quit();
    }
}
