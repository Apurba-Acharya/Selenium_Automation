package ex17_Selenium_Waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;

public class FluentWaits {

//    How to handle webdriver wait till download is not getting completed. -> TimeOutException.

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");
        String dowanlodPath = "C:\\Users\\apurb\\Downloads";
        String filename = "jenkins.msi";
        File file = new File(dowanlodPath, filename);

        FluentWait<File> fWaits = new FluentWait<File>(file)
                                .withTimeout(Duration.ofMinutes(5)) // wait maximum 5 mins to complete the download of this file before throwing timeOut exception
                                .pollingEvery(Duration.ofSeconds(5)) // every 5 secs it will check that download is continuing or not
                                .ignoring(Exception.class) // handling any exception
                                .withMessage("file is not downloaded");
        boolean isDowanloaded = fWaits.until(f -> f.exists() && f.canRead());
        if(isDowanloaded){
            System.out.println("file is 100% downloaded");
        }else {
            System.out.println("file not completely downloaded");
        }
    }
}
