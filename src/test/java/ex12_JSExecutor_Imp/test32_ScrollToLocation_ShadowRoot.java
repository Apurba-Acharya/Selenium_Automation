package ex12_JSExecutor_Imp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class test32_ScrollToLocation_ShadowRoot {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/shadow-dom");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Shadow DOM']")));

        JavascriptExecutor js =(JavascriptExecutor)driver;

        //scroll to defined location using js
        WebElement form = driver.findElement(By.xpath("//p[contains(text(),'This is just an example of shadom DOM')]"));
        js.executeScript("arguments[0].scrollIntoView(true);",form);

        // handling of shadow root:
        // Script format: WebElement element = (WebElement) js.executeScript( "return **Copy JS path;");
        WebElement element = (WebElement) js.executeScript(" return document.querySelector(\"#__next > section.mt-50 > div > div > div:nth-child(2) > shadow-signup-form\").shadowRoot.querySelector(\"div > form > div:nth-child(2) > div > input\") ;");
        element.sendKeys("ATB");
        WebElement submit = (WebElement) js.executeScript("return document.querySelector(\"#__next > section.mt-50 > div > div > div:nth-child(2) > shadow-signup-form\").shadowRoot.querySelector(\"div > form > div:nth-child(6) > div > button\") ;");
        submit.click();
    }
}
