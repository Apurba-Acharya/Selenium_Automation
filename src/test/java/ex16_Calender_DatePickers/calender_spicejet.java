package ex16_Calender_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class calender_spicejet {
    @Test
    public void calender() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Departure Date']")));
        driver.findElement(By.xpath("//div[normalize-space()='Departure Date']")).click();


        List<WebElement> list = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
        int monthcount = 0;

        for (WebElement month : list) {
            String calender = month.getText().toLowerCase();
            System.out.println(calender);
            ++monthcount;

            if (calender.contains("september")) {
                System.out.println("Pass");

                driver.findElement(By.xpath("(//div[@data-testid=\"undefined-calendar-day-14\"])[" + monthcount + "]")).click();
            }
        }
    }
}