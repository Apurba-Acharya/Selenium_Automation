package ex12_JSExecutor_Imp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class disableFieldHandling {
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
        driver.findElement(By.cssSelector("ul[class*='nav nav-pills nav-sid']>li:nth-of-type(2)>a>p")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".nav-item.menu-is-opening.menu-open>ul>li:nth-of-type(2)")).click();
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.cssSelector("#SurveyId"));
        Select dropd = new Select(element);
        dropd.selectByVisibleText("Market Price");
        Thread.sleep(10000);
        WebElement element2 = driver.findElement(By.cssSelector("#SUPId"));
        Select dropd2 = new Select(element2);
        dropd2.selectByVisibleText("demo");
    }
}
