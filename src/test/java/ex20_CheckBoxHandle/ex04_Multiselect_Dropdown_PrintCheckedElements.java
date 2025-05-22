package ex20_CheckBoxHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class ex04_Multiselect_Dropdown_PrintCheckedElements {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://admirhodzic.github.io/multiselect-dropdown/demo.html");

        driver.findElement(By.xpath("//div[@class=\"multiselect-dropdown\"][1]")).click();
        List<WebElement> element_select = driver.findElements(By.xpath("//div[@class=\"multiselect-dropdown\"][1]/div/div/div"));
        for (WebElement element : element_select){
            //System.out.println(element.getAttribute("class"));
            if(element.getAttribute("class").equals("checked")){
                System.out.println(element.getText());
            }
        }
        driver.quit();
    }
}
