package ex03_SeleniumDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class P1_SelectDropdown {
    @Test
    public void dropdown () {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement drpCountryEle = driver.findElement(By.cssSelector("#country"));
        //Select tag needs to be present:
        Select drpCountry = new Select(drpCountryEle);
        drpCountry.selectByVisibleText("France"); //Text which is displaying in the UI screen
        drpCountry.selectByValue("uk"); //Value coming under 'value' attribute => this should be work if the value attribute is present in DOM
        drpCountry.selectByIndex(3);

        //Capture options from the dropdown:
        List<WebElement>options = drpCountry.getOptions(); //return all the options from the dropdown as a WebElement
        System.out.println("Number of options in a dropdown: " + options.size());
        //Printing options:
//        for(int i=0; i<options.size(); i++){
//            System.out.println("Normal for loop: " + options.get(i).getText());
//        }
        //Enhanced for loop:
        for (WebElement dropOp:options){
            System.out.println("Enhanced for loop: " + dropOp.getText());
        }
    }
}
