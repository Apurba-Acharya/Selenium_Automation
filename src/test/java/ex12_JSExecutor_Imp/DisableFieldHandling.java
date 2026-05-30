package ex12_JSExecutor_Imp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DisableFieldHandling {
    @Test
    public void clearData() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://115.124.119.108:81/");
        driver.findElement(By.cssSelector("#username")).sendKeys("SRO.2310.001");
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled');", passwordField);
        js.executeScript("arguments[0].value='Mospi@12345';", passwordField);
        Thread.sleep(15000);
        driver.findElement(By.cssSelector("#loginButton")).click();
    }
}
