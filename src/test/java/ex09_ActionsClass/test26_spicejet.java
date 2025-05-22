package ex09_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class test26_spicejet {
    @Test
    public void test_actions() throws InterruptedException {
        EdgeOptions Options = new EdgeOptions();
        Options.addArguments("--InPrivate");

        WebDriver driver = new EdgeDriver(Options);
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        WebElement from = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//input[@type='text']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(from).click().build().perform();
        //actions.keyDown(Keys.SHIFT).sendKeys("blr").keyUp(Keys.SHIFT).build().perform();
        Thread.sleep(3000);
        actions.moveToElement(from).click().sendKeys("BLR").build().perform();

    }
}
