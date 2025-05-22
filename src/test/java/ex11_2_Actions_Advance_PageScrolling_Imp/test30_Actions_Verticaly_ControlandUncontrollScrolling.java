package ex11_2_Actions_Advance_PageScrolling_Imp;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class test30_Actions_Verticaly_ControlandUncontrollScrolling {
    @Test
    public void ControlScrolling() throws InterruptedException {

        //Control Scrolling:

        WebDriver driver = new EdgeDriver();
        driver.get("https://datatables.net/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='Examples']")).click();
        driver.findElement(By.xpath("//a[@href='/examples/basic_init']")).click();

        //Explicit wait till "Basic initialisation" element:
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='page_title']")));

        //Scroll to "Scroll - horizontal" element: Important
        JavascriptExecutor js  = (JavascriptExecutor) driver;
        WebElement element  = driver.findElement(By.xpath("//a[normalize-space()='Scroll - horizontal']"));
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        driver.findElement(By.xpath("//a[normalize-space()='Scroll - horizontal']")).click();
        Thread.sleep(5000);

        //ControlScrolling: Important
        Actions actions = new Actions(driver);
        WebElement targetelement  = driver.findElement(By.xpath("//a[normalize-space()='Ordering formatted dates (Luxon)']"));
        actions.scrollToElement(targetelement).perform();

        System.out.println("--------- Controlled Scroll Down End !!! ---------");

        Thread.sleep(7000);

        //Uncontrol Scrolling:
        driver.navigate().to("https://www.makemytrip.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='commonModal__close']")));
        driver.manage().window().maximize();
        WebElement cross = driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]"));
        cross.click();

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println("--------- Uncontrolled Scroll Down End!!! ---------");
    }
}