package ex16_Calender_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dynamicCalenderSpicejet {
    @Test
    public void ex() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https:///www.spicejet.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
        String month = "January";
        String year = "2026";
        String date = "20";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@data-testid=\"undefined-month-"+month+"-"+year+"\"]//div[@data-testid=\"undefined-calendar-day-"+date+"\"]/div")).click();

    }
}
