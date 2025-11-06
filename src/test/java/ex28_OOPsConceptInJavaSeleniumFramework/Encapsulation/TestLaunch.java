package ex28_OOPsConceptInJavaSeleniumFramework.Encapsulation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLaunch {
    public static void main(String[] args) throws InterruptedException {
        BrowserConfig config = new BrowserConfig();
        config.setBrowserName("chrome");
        WebDriver driver = null;
        if (config.getBrowserName().equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (config.getBrowserName().equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(config.getUsername());
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(config.getPassword());
        driver.quit();
    }
}
