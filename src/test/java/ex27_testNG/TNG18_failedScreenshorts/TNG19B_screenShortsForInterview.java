package ex27_testNG.TNG18_failedScreenshorts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TNG19B_screenShortsForInterview {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("Hello");
        //screenshot declaration
        TakesScreenshot tk=(TakesScreenshot) driver;
        File source= tk.getScreenshotAs(OutputType.FILE);
        File des=new File("C:\\Users\\APURBA ACHARYA\\IdeaProjects\\Selenium_Automation\\src\\test\\java\\ex27_testNG\\TNG18_failedScreenshorts.png");
        FileUtils.copyFile(source,des );
    }
}
