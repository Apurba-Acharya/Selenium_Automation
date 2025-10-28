package ex28_testNG.TNG4_Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class TNG5B_optionalParameters {
    WebDriver driver;

    @Parameters("browserName")
    @BeforeTest
    public void Intialisebrowser(@Optional("chrome") String browserName){
        switch(browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser name is invalid");
                break;
        }
        driver.manage().window().maximize();
        System.out.println("BeforeTest : Executed");
    }

    @Parameters("sleepTime")
    @AfterTest
    public void tearDown(String sleepTime){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.valueOf(sleepTime)));
        driver.quit();
        System.out.println("AfterTest : Executed");
    }

    @Parameters("url")
    @Test
    public void LaunchApp(String url){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Parameters({"username", "password"})
    @Test
    public void EnterLoginDetails(String username, String password) {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
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
        boolean actualValue=driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).isDisplayed();
        assertTrue(actualValue);
    }

    @Test
    public void VerifyLogin() {
        WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Upgrade']"));
        assertTrue(element.isDisplayed());
        assertTrue(element.getText().startsWith("Upgrade"));
    }
}
