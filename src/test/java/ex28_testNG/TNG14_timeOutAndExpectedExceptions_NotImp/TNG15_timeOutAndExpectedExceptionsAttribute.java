package ex28_testNG.TNG14_timeOutAndExpectedExceptions_NotImp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TNG15_timeOutAndExpectedExceptionsAttribute {
    @Test(timeOut = 2000)
    public void timeOut(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.quit();
    }

    //Expected exceptions handling:
    @Test(expectedExceptions = {NoSuchElementException.class, TimeoutException.class})
    public void expectedExceptions(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("abcd")).click();
        driver.quit();
    }
}
