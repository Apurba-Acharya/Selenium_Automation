package ex20_CheckBoxHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class ex01_StaticDropdown_SelectClass {
    public static void main(String[] args) throws InterruptedException {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getTitle());

        WebElement element_select = driver.findElement(By.id("dropdown"));
        Select select = new Select(element_select);
        select.selectByVisibleText("Option 2");
        Thread.sleep(5000);
        //Or, >>
        select.selectByIndex(1);

    }
}
