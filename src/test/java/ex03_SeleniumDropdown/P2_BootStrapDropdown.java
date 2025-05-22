package ex03_SeleniumDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class P2_BootStrapDropdown {
    @Test
    public void dropdown () {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".multiselect-selected-text")).click();

        // Select single option from the dropdown:
        //driver.findElement(By.cssSelector(".multiselect-container.dropdown-menu>li:nth-of-type(8)>a>label>input")).click();

        //Capture all options and find out the size:
       List<WebElement>options = driver.findElements(By.cssSelector(".multiselect-container.dropdown-menu>li>a>label"));
       System.out.println("Number of options: " + options.size());

       //Printing options from the dropdown:
//       for(WebElement dropOptions:options){
//           System.out.println(dropOptions.getText());
//       }

       //Select multiple options:
        for(WebElement dropOp:options){
            String drop = dropOp.getText();
            if (drop.equals("C#") || drop.equals("jQuery") || drop.equals("Oracle")){
                dropOp.click();
            }
        }
    }
}
