package ex10_Windowsandiframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class test28_switchto_getWindowHandles_byArrayList_Important {
    @Test
    public void window_popup_modal() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login"); // Position: 0th //using tab.size(): 0st
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@href=\"https://www.linkedin.com/company/orangehrm/mycompany/\"]/*[name()='svg']")).click();
        driver.findElement(By.xpath("//a[@href=\"https://twitter.com/orangehrm?lang=en\"]/*[name()='svg']")).click();
        driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']//*[name()='svg']")).click();

        String window = driver.getWindowHandle();
        System.out.println("Parent window ID: " + window);

        Set <String> windows = driver.getWindowHandles();
        List <String> tabs = new ArrayList<>(windows);

        for (String e : tabs){
            String title = driver.switchTo().window(e).getCurrentUrl();
            System.out.println(title);
            if (title.contains("https://x.com/orangehrm?lang=en&mx=2")){
                Thread.sleep(7000);
                driver.close();
            }
        }
    }
}
