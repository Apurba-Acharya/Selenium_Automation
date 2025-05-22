package ex13_Relative_Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class test35_Relative_Locators_Advance {
    @Test
    public void RL(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();

        List <WebElement> locations = driver.findElements(By.xpath("//div[contains(@class, \"location-name\")]/p"));
        for (WebElement l : locations){
            System.out.println(l.getText());
            String rank = driver.findElement(with(By.xpath("//p[contains(@class, \"location-rank\")]")).toLeftOf(l)).getText();
            String aqi = driver.findElement(with(By.xpath("//div[contains(@class, \"aqi-status\")]")).toRightOf(By.xpath("//div[contains(@class, \"aqi-level\")]")).toRightOf(l)).getText();
            System.out.println(rank + l.getText() + aqi);
        }
    }
}
