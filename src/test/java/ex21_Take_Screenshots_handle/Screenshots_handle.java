package ex21_Take_Screenshots_handle;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.io.IOException;

public class Screenshots_handle {
    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");
        takeScreenshot("app.vwo.com_login");
        driver.navigate().to("https://awesomeqa.com/hr/web/index.php/auth/login");
        Thread.sleep(5000);
        takeScreenshot("OrangeHR");
    }

    public static void takeScreenshot (String fileName) throws IOException {
        //1. take screenshot and store it as a file format
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //2. now copy the screenshot to desired location using copyfile method
        FileUtils.copyFile(file, new File("C:\\Users\\apurb\\IdeaProjects\\Selenium_Automation\\src\\test\\java\\ex21_Take_Screenshots_handle\\screenShots" + fileName +".jpg"));
        //driver.quit();
    }
}