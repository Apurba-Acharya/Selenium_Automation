package ex04_Selenium_OptionClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class P1 {
    @Test
    public void selenium01 () throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
//        edgeOptions.addArguments("--window-size=400,700");
        //edgeOptions.addArguments("--start maximized");
//        edgeOptions.addArguments("--headless");

        edgeOptions.addArguments("--InPrivate");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://google.com");
        Thread.sleep(1000);
        //driver.quit();

    }
}
