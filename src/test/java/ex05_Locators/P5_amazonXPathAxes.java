package ex05_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class P5_amazonXPathAxes {
    WebDriver driver;

    @Test
    public void amazonXPath() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert soft = new SoftAssert();
        try {

            WebElement continueBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'a-button-inner')]//button")));
            if (continueBtn.getText().equalsIgnoreCase("Continue shopping")) {
                continueBtn.click();
            }
        } catch (TimeoutException e) {
            System.out.println("'Continue shopping' button not found, proceeding to search...");
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Search Amazon.in']/following-sibling::input"))).sendKeys("Phones");
            driver.findElement(By.xpath("//span[@aria-label='Go']/child::input")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@aria-label, 'See more, Brands')]"))).click();

            List<WebElement> mobiles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@id, 'brandsRefinements')]//*[contains(@role, 'presentation')]")));
            boolean brandFound = false;
            for (WebElement listMob : mobiles) {
                if (listMob.getText().equalsIgnoreCase("CMF BY NOTHING")) {
                    listMob.click();
                    brandFound = true;
                    break;
                }
            }
            if (!brandFound) {
                System.out.println("Brand not found, continuing...");
            }

        } catch (TimeoutException e) {
            System.out.println("Search or brand selection elements not found, skipping...");
        }

        //sortBy button:
        driver.findElement(By.xpath("//span[@class=\"a-dropdown-container\"]/descendant::span[2]")).click();
        List<WebElement> sortBy = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.cssSelector(".a-nostyle.a-list-link>li>a"))));
        for (WebElement sorted : sortBy){
            String s = sorted.getText();
            System.out.println(s);
            if(sorted.getText().trim().equals("Newest Arrivals")){
                sorted.click();
            }
        }

    }
}
