package ex28_testNG.TNG16_invocation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TNG17A_invocationCount {

    // Invocation count is a parameter/attribute which tells the test methods like how many number of times the same test methods should be invoked/executed.
    @Test(invocationCount = 3)
    public void testmethod1() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://randomuser.me/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//li[@data-label='name']")).click();
        System.out.println("User name: " + driver.findElement(By.id("user_value")).getText());

        driver.findElement(By.xpath("//li[@data-label='email']")).click();
        System.out.println("Email address: " + driver.findElement(By.id("user_value")).getText());
        driver.quit();
    }

}
