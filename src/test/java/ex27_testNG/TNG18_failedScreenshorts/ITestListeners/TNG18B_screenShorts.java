package ex27_testNG.TNG18_failedScreenshorts.ITestListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

@Listeners(TNG18A_listenersClass.class)
public class TNG18B_screenShorts extends TNG18A_listenersClass {
    @Test(testName = "TestGoogle")
    public void TestGoogle() throws Exception {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        boolean expecTitle = true;
        boolean actualTitle = driver.getTitle().contains("xxYR+Tutorials");
        assertEquals(actualTitle, expecTitle, "Title is mismatched");
    }

    @Test(testName = "TestFacebook")
    public void TestFacebook() throws Exception {
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("email")).sendKeys("HYR", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));

        SoftAssert sa = new SoftAssert(); // methods available in hard assert also available in soft assert

        //Title assertion:
        String actualTitle= driver.getTitle();
        String expectedTitle= "Log in to Facebook";
        assertEquals(actualTitle, expectedTitle, "Title is mismatched");

        //URL asssertion:
        String actualURL=driver.getCurrentUrl();
        String expectedURL= "https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNzYwNDk2MzY4LCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D&next";
        sa.assertNotEquals(actualURL, expectedURL, "URL is mismatched");

        //Text assertion:
        String actualText= driver.findElement(By.name("email")).getAttribute("value");
        String expectedText= "";
        assertEquals(actualText, expectedText, "username text is mismatched");

        //Border assertion:
        String actualBorder= driver.findElement(By.name("email")).getCssValue("border");
        String expectedBorder= "0.8px solid rgb(240, 40, 73)";
        assertEquals(actualBorder, expectedBorder, "username border is mismatched");

        //error message
        String actualErrorMessage= driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText().trim();
        String expectedErrorMessage= "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
        assertEquals(actualErrorMessage, expectedErrorMessage, "username error message is mismatched");

        sa.assertAll();
    }

    @Test(testName = "TestOrangeHRM")
    public void TestOrangeHRM() throws Exception {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin1234");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Upgrade']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
