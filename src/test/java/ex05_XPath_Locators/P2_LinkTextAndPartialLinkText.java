package ex05_XPath_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class P2_LinkTextAndPartialLinkText {
    @Test
    public void selenium01 () throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");

        //<a
        // href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        // class="text-link"
        // data-qa="bericafeqo">
        // Start a free trial
        // </a>
//        WebElement linkText = driver.findElement(By.className("text-link"));
//        linkText.click();

//        WebElement a_tag = driver.findElement(By.linkText("Start a free trial"));
//        a_tag.click();
        WebElement a_tag = driver.findElement(By.partialLinkText("Start"));
        a_tag.click();

        Thread.sleep(5000);
        //driver.quit();
    }
}
