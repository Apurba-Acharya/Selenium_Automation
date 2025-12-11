package ex12_JSExecutor_Imp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HighlightElement_JSExecuter {
    @Test
    public void LoginpagewithHighlighter()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.headspace.com/login");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("email"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style','background:red;border:4px solid green;')", email);
    }

}
