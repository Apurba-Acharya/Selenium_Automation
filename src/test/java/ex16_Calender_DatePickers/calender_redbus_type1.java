package ex16_Calender_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class calender_redbus_type1 {
    @Test
    public void calender() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='dateText']")));
        driver.findElement(By.xpath("//span[@class='dateText']")).click();

        String s = driver.findElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']/div[2]")).getText();

        while (!(s.contains("Jan") && s.contains("2026"))) {
            driver.findElement(By.xpath("//div[@class=\"DayNavigator__IconBlock-qj8jdz-2 iZpveD\"][3]/*[name()='svg']")).click();
            Thread.sleep(1000);
            s = driver.findElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']/div[2]")).getText();
        }
        driver.findElement(By.xpath("//span[normalize-space()='9']")).click();
        String date_name = driver.findElement(By.xpath("//div[@class='sc-kAzzGY cCrHkP']")).getText();
        System.out.println(date_name);
    }
}