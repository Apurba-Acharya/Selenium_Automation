package ex17_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWaits {
    @Test
    public void p1 () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        //Implicit wait >> Exception message: No such element exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement t2 = driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]"));
        t2.sendKeys("gas stoves"+ Keys.ENTER);
//        WebElement t3 = driver.findElement(By.xpath("//button[@class=\"_2iLD__\"]"));
//        t3.click();

        //Explicit wait >> Exception message: TimeoutException
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class=\"SwtzWS\"]")));
        WebElement t1 = driver.findElement(By.xpath("//div[@class=\"QCKZip hpLdC3\"]/label[1]/div[@class=\"XqNaEv\"]"));
        t1.click();
    }
}
