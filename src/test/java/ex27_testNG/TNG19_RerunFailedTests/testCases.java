package ex27_testNG.TNG19_RerunFailedTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCases {
    WebDriver driver;

    @BeforeTest()
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(driver.getTitle());
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
        System.out.println("Testing_AfterTest");
    }
    @Test(retryAnalyzer = RerunFailedScript.class)
    public void testMethod(){
        String title = driver.getTitle();
        Assert.assertEquals(title, "rangeHRM");
        System.out.println("Testing_Test");
    }
}
