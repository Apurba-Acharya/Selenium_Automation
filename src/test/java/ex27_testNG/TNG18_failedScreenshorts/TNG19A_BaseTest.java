package ex27_testNG.TNG18_failedScreenshorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TNG19A_BaseTest {
    public static WebDriver driver;
    public static String screenshotsSubFolderName;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod // Dependency Injection Concept: this also used to capture the screenshorts. Either we can use testNG listener or Dependency Injection Concept
    public void screenshortCapture(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            captureScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+".jpg");
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    public void captureScreenshot(String fileName) {
        if(screenshotsSubFolderName == null) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            screenshotsSubFolderName = myDateObj.format(myFormatObj);
        }

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/"+ screenshotsSubFolderName+"/"+fileName); // ./ => this is indicating the current project directory
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
    }
}
