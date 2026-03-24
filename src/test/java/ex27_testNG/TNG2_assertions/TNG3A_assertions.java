package ex27_testNG.TNG2_assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class TNG3A_assertions {
    @Test
    public void testgoogle(){
        /* 1. assertEquals
        2. assertNotEquals
        3. assertTrue
        4. assertFalse
        5. assertNull
        6. assertNotNull */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("q")).sendKeys("JavaSelenium", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
        String expectedTitle = "https://www.google.com/search?q=JavaSelenium&sca_esv=06680e941bb4b5b6&source=hp&ei=TJPuaLDNDvqWnesP24jUiAY&iflsig=AOw8s4IAAAAAaO6hXC0izTdLjbTY0NLUlC884B6Kg83R&ved=0ahUKEwiwo9j4paSQAxV6S2cHHVsEFWEQ4dUDCBA&uact=5&oq=JavaSelenium&gs_lp=Egdnd3Mtd2l6IgxKYXZhU2VsZW5pdW1INFAAWC9wAHgAkAEAmAEAoAEAqgEAuAEDyAEA-AEBmAIAoAIAmAMAkgcAoAcAsgcAuAcAwgcAyAcA&sclient=gws-wiz&sei=TZPuaL2fF-SwwcsPs7TJgAQ";
        String actuslTitle = driver.getTitle();
        assertEquals(actuslTitle, expectedTitle, "Test failed");
        /* 1. Hard assertion: Is an assertion which threw the exception immediately upon failure of assertion.
           2. difference between hard and soft assertion: in hard if the assertion is failed, the exception will through immediately.
           3. In soft if the assertion got failed, it will not through the exception immediately. */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
        driver.quit();
    }

    @Test
    public void testfaceBook(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("email")).sendKeys("HYR", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.getTitle());
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

        driver.quit();
        sa.assertAll(); // In soft assert if there is any failure, then to through the assertion assertAll method will work at the end of the test execution.
    }
}
