package ex16_Calender_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class calender_1 {
    @Test
    public void calender () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver. manage().window().maximize();
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Calendar Handle']")));
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

        while (!(month.contains("December") && year.contains("2023"))){
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            Thread.sleep(1000);
            month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
        }
        driver.findElement(By.xpath("//a[normalize-space()='31']")).click();
    }
}

