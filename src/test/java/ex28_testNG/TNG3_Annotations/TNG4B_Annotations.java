package ex28_testNG.TNG3_Annotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TNG4B_Annotations {
    WebDriver driver;

    @BeforeTest
    public void Intialisebrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("BeforeTest : Executed");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        System.out.println("AfterTest : Executed");
    }
    @Test
    public void LaunchApp() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void EnterLoginDetails() {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void NavigateToMyInfo() {
        driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void VerifyMyInfo() {
        System.out.println(driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).isDisplayed());
    }

    @Test
    public void VerifyLogin() {
        WebElement element = driver.findElement(By.xpath("//h6[normalize-space()='PIM']"));
        System.out.println(element.isDisplayed());
        System.out.println(element.getText());
    }
}

