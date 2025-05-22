package ex09_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class test27_makemytrip {
    @Test
    public void test_actions() throws InterruptedException {
//         EdgeOptions Options = new EdgeOptions();
//         Options.addArguments("--InPrivate");
//
////        ChromeOptions Options = new ChromeOptions();
////        Options.addArguments("--Ingognito");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.makemytrip.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='commonModal__close']")));
        driver.manage().window().maximize();

        WebElement cross = driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]"));
        cross.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fromCity']")));
        WebElement from = driver.findElement(By.xpath("//input[@id='fromCity']"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(from).click().build().perform();
        actions.moveToElement(from).click().sendKeys("goa").build().perform();

        //actions.moveToElement(from).contextClick(); >> Mouse right key.

//        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));
//        for (WebElement e : list_auto_complete) {
//            if (e.getText().contains("Goa")) {
//                e.click();
//                break;
//            }
//        }
        Thread.sleep(3000);
        actions.moveToElement(from).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
    }

}
