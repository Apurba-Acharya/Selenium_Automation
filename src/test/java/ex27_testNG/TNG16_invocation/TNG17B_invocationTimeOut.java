package ex27_testNG.TNG16_invocation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TNG17B_invocationTimeOut {

    // Invocation timeOut will restrict the entire invocation execution restriction time: ErrorMessage: org.testng.internal.thread.ThreadTimeoutException

    @Test(invocationCount = 3, invocationTimeOut = 10000)
    public void testmethod2() throws Exception {
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
