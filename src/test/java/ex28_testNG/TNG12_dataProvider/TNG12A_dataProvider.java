package ex28_testNG.TNG12_dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TNG12A_dataProvider {
    // what is ?: this is a container which passes the test data to our test method.
    // why ?: To parameterized the data to test methods.
    // what will happen if we not use dataProvider with @Test?: If we have multiple data provider then to identify each data provider uniquly we needs to assign the name to dataProvider.
    // what will happen if name="loginTestData" is not pass through @DataProvider: It will through java.lang.exception to provide a name="loginTestData". In case if we not passing any dataProvider name then we can use the method name as data provider.

    @Test(dataProvider = "loginTestData") // we can use: dataProvider = "loginData1" ---> method name
    public void testHRM(String username, String password){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Upgrade']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();
    }

    @DataProvider(name="loginTestData")
    public Object[][] loginData1(){
        Object[][] data= new Object[2][2];
        data[0][0]= "Admin";
        data[0][1]= "admin123";

        data[1][0]= "Admin";
        data[1][1]= "test123";
        return data;
    }

//    @DataProvider
//    public void loginData2(){
//
//    }
//
//    @DataProvider
//    public void loginData3(){
//
//    }

}
