package ex19_Selenium_RadioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputBox_Checkbox_RadioBox {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();

        //Text Box >>
        WebElement textbox = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        textbox.sendKeys("ATB9x");
        //RadioBox >>
        WebElement radio = driver.findElement(By.xpath("//input[@id=\"sex-1\"]"));
        radio.click();
        //CheckBox (Normal) >>
        WebElement checkbox = driver.findElement(By.xpath("//input[@id=\"tool-1\"]"));
        checkbox.click();
    }
}
