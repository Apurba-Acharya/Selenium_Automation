package ex22_HyperLink_Handle;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class HyperLink {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("testwisely")).click(); //Hperlink handled using LinkText.

        System.out.println("Link Text URL is: " + driver.getCurrentUrl());
        System.out.println("Title of Current URL: " + driver.getTitle());
        driver.quit();
    }
}
