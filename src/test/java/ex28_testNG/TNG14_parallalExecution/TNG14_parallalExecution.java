package ex28_testNG.TNG14_parallalExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TNG14_parallalExecution {
    @Test(dataProvider = "loginData1") // we can use: dataProvider = "loginData1" ---> method name
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

    /* When we needs to parallay run all sets of data data in the application.
     And If needs to sun a specific sets of data needs to run then we needs to configure testNG.xml */
    @DataProvider(parallel = true)
    public Object[][] loginData1(){
        Object[][] data= new Object[6][2];
        data[0][0]= "Admin";
        data[0][1]= "admin123";

        data[1][0]= "Admin";
        data[1][1]= "test123";

        data[2][0]= "qa";
        data[2][1]= "admin123";

        data[3][0]= "stage";
        data[3][1]= "test123";

        data[4][0]= "prod";
        data[4][1]= "admin123";

        data[5][0]= "qaStage";
        data[5][1]= "test123";
        return data;
    }
}
