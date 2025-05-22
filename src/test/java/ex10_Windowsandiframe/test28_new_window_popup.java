package ex10_Windowsandiframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.Set;

public class test28_new_window_popup {
    @Test
    public void window_popup_modal() throws InterruptedException {
        //Options class:
        EdgeOptions Options = new EdgeOptions();
        Options.addArguments("--InPrivate");

        WebDriver driver = new EdgeDriver(Options);
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");

        // WindowHandle:
        String parent = driver.getWindowHandle();
        System.out.println("Parent window ID: " + parent);

        driver.findElement(By.xpath("//a[normalize-space()='Like us On Facebook']")).click();

        //WindowHandles:
        Set <String> handles = driver.getWindowHandles();
        for (String h : handles){
            System.out.println("Windows ID: " + h);
            if (!h.equals(parent)){
                driver.switchTo().window(h);
                driver.manage().window().maximize();
                driver.findElement(By.xpath("//div[@class=\"x92rtbv x10l6tqk x1tk7jg1 x1vjfegm\"]/div[@role=\"button\"]")).click();
                String s2 = driver.findElement(By.xpath("//div [@class=\"x1e56ztr x1xmf6yo\"]/span/h1")).getText();
                System.out.println("New frame element: " + s2);
                //driver.close();
            }
        }
        driver.switchTo().window(parent);
        String main_page = driver.findElement(By.xpath("//h1[normalize-space()='Window popup Modal']")).getText();
        System.out.println("Parent page title: " + main_page);
    }
}
