package ex10_Windowsandiframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class test29_window_iframe_Important {
    @Test
    public void p5() throws InterruptedException {
        EdgeOptions Options = new EdgeOptions();
        Options.addArguments("--InPrivate");

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(Options);
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        String parentwindow = driver.getWindowHandle();
        System.out.println("Parent - " + parentwindow);

        List<WebElement> list_heatmaps = driver.findElements(By.xpath("//div[@data-qa='campaign-view']/div/div/ul/li"));

        Actions actions = new Actions(driver);
        actions.moveToElement(list_heatmaps.get(1)).click().build().perform();
        Thread.sleep(13000);

        Set<String> allhandles = driver.getWindowHandles();
        System.out.println("All handles: " + allhandles);
        for (String handles : allhandles) {
            driver.switchTo().window(handles);
            if (driver.getTitle().contains("Job Ready Automation Tester Blueprint with JAVA By Pramod Dutta")) {
                System.out.println("Passed -- " + driver.getTitle());
                driver.switchTo().frame("heatmap-iframe");
                WebElement clickmap = driver.findElement(By.xpath("//div[@data-qa=\"liqokuxuba\"]"));
                clickmap.click();

            }
        }
        driver.switchTo().window(parentwindow);
    }
}