package ex03_SeleniumDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class P4_AutoSuggestDropdown {
    @Test
    public void autoSuggest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector(".gLFyf,text[aria-controls='Alh6id']")).sendKeys("Selenium");
        Thread.sleep(5000);
        List<WebElement> autoDropdown = driver.findElements(By.cssSelector("ul[jsname='bw4e9b']>li>div>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>span"));
        System.out.println(autoDropdown.size());
        for (WebElement dropD:autoDropdown){
            if (dropD.getText().contains("webdriver")){
                dropD.click();
                break;
            }
        }

    }
}
