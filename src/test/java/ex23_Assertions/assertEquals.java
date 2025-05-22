package ex23_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assertEquals {
    @Test
    public void TestAssertions (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        String currentTitle = driver.getTitle();

        Assert.assertEquals(currentTitle, "Google", "Matching");

//        SoftAssert SoftAssertion = new SoftAssert();
//        SoftAssertion.assertEquals(currentTitle, "google");

        String element = driver.findElement(By.xpath("//div[@class='RNNXgb']")).getAttribute("jsname");
        Assert.assertEquals(element, "RNNXg", "notMatching");
        driver.close();

//        SoftAssertion.assertAll(); //Print al assertion in readable format

    }
}
