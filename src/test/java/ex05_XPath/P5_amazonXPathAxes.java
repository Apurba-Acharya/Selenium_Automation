package ex05_XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class P5_amazonXPathAxes {
    WebDriver driver;

    @Test
    public void amazonXPath(){
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//label[text()=\"Search Amazon.in\"]/following-sibling::input")).sendKeys("Phones"); //following-sibling
        driver.findElement(By.xpath("//span[@aria-label=\"Go\"]/child::input")).click(); //child
        driver.findElement(By.xpath("//*[contains(@aria-label, \"Apply the filter Samsung\")]/descendant::i")).click(); // descendant

    }
}
