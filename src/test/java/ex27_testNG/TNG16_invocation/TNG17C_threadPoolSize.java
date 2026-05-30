package ex27_testNG.TNG16_invocation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TNG17C_threadPoolSize {

    // working is same as thread-count. threadPoolSize can work when invocationCount is provided.
    
    @Test(invocationCount = 4, threadPoolSize = 2)
//    invocationCount = 4 → Test method will run 4 times.
//    threadPoolSize = 2 → At most 2 threads will run those invocations in parallel.

    public void testMethod4() throws Exception {
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
