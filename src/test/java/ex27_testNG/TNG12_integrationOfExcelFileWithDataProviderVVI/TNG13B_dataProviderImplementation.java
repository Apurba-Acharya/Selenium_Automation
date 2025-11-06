package ex27_testNG.TNG12_integrationOfExcelFileWithDataProviderVVI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TNG13B_dataProviderImplementation {
    @Test(dataProvider = "getData", dataProviderClass = TNG13A_excelDataSupllier.class) // we can use: dataProvider = "loginData1" ---> method name
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
}
