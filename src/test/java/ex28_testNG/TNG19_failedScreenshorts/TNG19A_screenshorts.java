package ex28_testNG.TNG19_failedScreenshorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class TNG19A_screenshorts {
    @Test
    public void TestGoogle() throws Exception {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
        String expectedTitle = "HYR Tutorials - Google Search";
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expectedTitle, "Title is mismatch");
    }
    public void TestFacebook() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.name("email")).sendKeys("HYR Tutorials", Keys.ENTER);
        Thread.sleep(2000);

        SoftAssert softAssert = new SoftAssert();
        //Title Assertion
        String actualTitle = driver.getTitle();
        String expectedTitle = "Log in to Facebook";
        softAssert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
    }

}
