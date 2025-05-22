package ex03_SeleniumDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class P3_HiddenDropdown {
    @Test
    public void dropdown () {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

        driver.findElement(By.cssSelector("div:nth-child(6) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1)")).click();
        //driver.findElement(By.cssSelector(".oxd-select-dropdown.--positon-bottom>div:nth-of-type(5)")).click();

        //Count number of options:
        List<WebElement>dropOptions=driver.findElements(By.cssSelector(".oxd-select-dropdown.--positon-bottom>div>span"));
        System.out.println(dropOptions.size());
        for (WebElement options:dropOptions){
            System.out.println("Enhanced loop: " + options.getText());
//            String drop = options.getText();
//            if(drop.equals("QA Lead")){
//                options.click();
//                break;
//            }
        }
    }
}
