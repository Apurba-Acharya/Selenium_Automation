package ex27_testNG.TNG11_dataProviderVVI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TNG12A_dataProvider {
    /* what is ?: this is a container which passes the test data to our test method.
       why ?: To parameterize the data to test methods.
       what will happen if we not use dataProvider with @Test?: If we have multiple data provider then to identify each data provider uniquely needs to assign the name to dataProvider.
       what will happen if name="loginTestData" is not pass through @DataProvider: It will through java.lang.exception to provide a name="loginTestData".
       In case if we're not passing any dataProvider name then we can use the method name as data provider.
    */

    @Test(dataProvider = "loginTestData") // or we can use -> dataProvider = "loginData1" ---> method name
    public void testHRM(String username, String password){
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

            Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Upgrade']")).isDisplayed());

        } catch (Exception e) {
            System.out.println("Test failed due to: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @DataProvider(name="loginTestData")
    public Object[][] loginData1(){
        Object[][] data= new Object[2][2];

        /* Creates a 2x2 array:
        2 rows → 2 sets of test data.
        2 columns → username and password. */

        data[0][0]= "Admin"; // -> 0th row=> key:username
        data[0][1]= "admin123"; // -> 0th row=> value:password

        data[1][0]= "Admin"; // -> 1th row=> key:username
        data[1][1]= "test123"; // -> 1th row=> value:password
        return data;
    }
}
