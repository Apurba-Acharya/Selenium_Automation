package ex10_Windowsandiframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class test28_window_tab {
    @Test
    public void p4() throws InterruptedException {
//         EdgeOptions Options = new EdgeOptions();
//         Options.addArguments("--InPrivate");
//
////        ChromeOptions Options = new ChromeOptions();
////        Options.addArguments("--Ingognito");
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        //window handle >>
        String parentwindow = driver.getWindowHandle();
        System.out.println("Parent window: " + parentwindow);

        //window handles >>
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("window handles: " + windowHandles);

        for (String handle : windowHandles){
            String navigate = driver.switchTo().window(handle).getCurrentUrl();
            System.out.println(navigate);
            if(navigate.contains("https://the-internet.herokuapp.com/windows/new")){
                driver.findElements(By.xpath("//h3[normalize-space()='New Window']")).contains("New Window");
                driver.close();
                System.out.println("----------Passed!----------");
            }
        }
    }
}
