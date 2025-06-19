package ex22_HyperLink_Handle;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

    public class HyperLink{
    @Test
    public void main() {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.linkText("testwisely")).click(); //Hperlink handled using LinkText.

        System.out.println("Link Text URL is: " + driver.getCurrentUrl());
        System.out.println("Title of Current URL: " + driver.getTitle());
        driver.quit();
    }
}