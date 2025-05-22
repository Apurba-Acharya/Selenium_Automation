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

public class calender_spicejet2 {
    @Test
    public void calender() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Departure Date']")));
        driver.findElement(By.xpath("//div[normalize-space()='Departure Date']")).click();

        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"css-1dbjc4n r-1euycsn\"]/div[2]/div/div"));
        Thread.sleep(2000);
        for (WebElement month : list) {
            String calender = month.getText().toLowerCase();
            System.out.println(calender);
            if (calender.contains("october") && calender.contains("2025")){
                driver.findElement(By.xpath("(//div[@data-testid=\"undefined-calendar-day-14\"])[" + month + "]")).click();
                //month.click();
            }
        }
    }
}

//        List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"css-1dbjc4n r-1euycsn\"]/div[2]/div/div[2]/div/div[3]/div/div"));
//        for (WebElement ele : elements) {
//        System.out.println(ele.getText());