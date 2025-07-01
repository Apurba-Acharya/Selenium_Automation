package ex04_Selenium_OptionClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class P2_Extensions {
    @Test
    public void selenium01 () throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addExtensions(new File("C:\\Users\\apurb\\IdeaProjects\\Selenium_Automation\\src\\test\\java\\ex04_Selenium_OptionClass\\AdBlock.crx"));

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://youtube.com");
        Thread.sleep(15000);
    }
}
