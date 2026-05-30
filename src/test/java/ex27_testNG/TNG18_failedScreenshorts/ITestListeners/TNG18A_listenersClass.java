package ex27_testNG.TNG18_failedScreenshorts.ITestListeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TNG18A_listenersClass implements ITestListener {

    public static WebDriver driver;
    public static String screenshotsSubFolderName;

    // ================= BeforeTest & AfterTest ==================
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    // ================= Screenshot Utility ==================
    public void captureScreenshot(String fileName) { //This method will create a folder using dateAndTime stamp under screenShorts folder. Basically to avoid the duplication.
        if (screenshotsSubFolderName == null) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
            screenshotsSubFolderName = myDateObj.format(myFormatObj);
        }

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/" + screenshotsSubFolderName + "/" + fileName); // ./ => this is indicating the current project directory

        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
    }

    // ================= ITestListener Methods ==================
    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotName = result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg";
        System.out.println("Test Failed: Capturing Screenshot → " + screenshotName);
        captureScreenshot(screenshotName);
    }
}

