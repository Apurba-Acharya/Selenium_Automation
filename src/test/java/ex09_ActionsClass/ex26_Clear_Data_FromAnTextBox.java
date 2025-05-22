package ex09_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ex26_Clear_Data_FromAnTextBox {
    @Test
    public void clearData() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.netflix.com/in/");
        driver.findElement(By.cssSelector("input[id=':r13:']")).sendKeys("abcde@abcde.gmail.com");
        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.cssSelector("input[id=':r13:']")))
                .keyDown(Keys.CONTROL)
                .sendKeys("a") // Ctrl + a
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .build().perform();
    }
}
