package ex27_testNG.TNG13_dataProviderParallalExecutionVVI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TNG14_parallalExecution {
    @Test(dataProvider = "loginData1") // we can use: dataProvider = "loginData1" ---> method name
    public void testHRM(String username, String password) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//button[normalize-space()='Upgrade']")).isDisplayed());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        } finally {
            driver.quit();
        }
    }


    /* When we need to parallay run all sets of data in the application.
     And If it needs to sun a specific sets of data needs to run then we need to configure testNG.xml */
    @DataProvider(parallel = true)
    public Object[][] loginData1(){
        Object[][] data= new Object[6][2]; // Rows: 6; Columns: 2
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
