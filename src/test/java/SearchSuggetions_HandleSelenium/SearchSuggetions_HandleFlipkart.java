package SearchSuggetions_HandleSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchSuggetions_HandleFlipkart {
    @Test
    public void searchFlipkart() throws InterruptedException {
        ChromeOptions Options = new ChromeOptions();
        Options.addArguments("--Incognito");

        WebDriver driver = new ChromeDriver(Options);
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search for Products, Brands and More']")));

        driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("laptop");
        Thread.sleep(7000);
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class=\"_1sFryS _2x2Mmc _3ofZy1\"]/li[@class=\"_3D0G9a\"]"));
        for (WebElement eles : elements) {
            if (eles.getText().contains("laptop under 20000")) {
                    eles.click();
            }
        }
    }
}