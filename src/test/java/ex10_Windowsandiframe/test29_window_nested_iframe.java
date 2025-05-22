package ex10_Windowsandiframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class test29_window_nested_iframe {
    @Test
    public void p5() throws InterruptedException {
//         EdgeOptions Options = new EdgeOptions();
//         Options.addArguments("--InPrivate");
//
////        ChromeOptions Options = new ChromeOptions();
////        Options.addArguments("--Ingognito");
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
        String Nested_iFrames = driver.findElement(By.xpath("//h5[normalize-space()='Nested iFrames']")).getText();
        System.out.println(Nested_iFrames);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
        String Demo = driver.findElement(By.xpath("//h5[normalize-space()='iFrame Demo']")).getText();
        System.out.println(Demo);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ABCDERT");
    }
}