package ex20_CheckBoxHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class ex02_Multiselect_Dropdown {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://admirhodzic.github.io/multiselect-dropdown/demo.html");

        driver.findElement(By.xpath("//body/div[@class='container']/div/div/div[2]")).click();
        List<WebElement> element_select = driver.findElements(By.xpath("//div[@class=\"multiselect-dropdown\"][2]/div/div/div"));
        for (WebElement element : element_select){
            if (element.getText().equals("Tesla") || element.getText().equals("Suzuki")){
                element.click();
            }
        }
    }
}
