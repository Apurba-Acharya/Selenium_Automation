package ex18_Selenium_AlertsBox;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A1_AlertsHandle {
    @Test
    public void alerts(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        //Alert with Ok button :
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Alert myalert = driver.switchTo().alert();
        System.out.println(myalert.getText());
        myalert.accept();
        String message = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(message, "You successfully clicked an alert");

        //Alert with Ok & Cancel button:
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//        driver.switchTo().alert().accept(); //Close alert with Ok button
        driver.switchTo().alert().dismiss(); //Close alert with Cancel button

        //Alert with Input box:
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Alert myPromtAlert = driver.switchTo().alert();
        myPromtAlert.sendKeys("WelCome");
        myPromtAlert.accept();
        String PromtMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(PromtMessage, "You entered: WelCome");
    }
}
