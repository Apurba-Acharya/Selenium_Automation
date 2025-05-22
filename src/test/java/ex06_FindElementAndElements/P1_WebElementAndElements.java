package ex06_FindElementAndElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class P1_WebElementAndElements {
    @Test
    public void katalon() throws InterruptedException {
        ChromeOptions eo = new ChromeOptions();
        eo.addArguments("--Incognito");

        WebDriver driver = new ChromeDriver(eo);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        Thread.sleep(3000);

        WebElement make_appointment_button = driver.findElement(By.xpath("//a[@href=\"./profile.php#login\"]"));
        make_appointment_button.click();

        WebElement username = driver.findElement(By.xpath("//input[@id=\"txt-username\"]"));
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"txt-password\"]"));
        password.sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id=\"btn-login\"]")).click();
        Thread.sleep(15000);
        List<WebElement> username_input_box = driver.findElements(By.xpath("//select[@id=\"combo_facility\"]//option"));
        username_input_box.get(2).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        Thread.sleep(3000);
        //driver.quit();
    }
}
