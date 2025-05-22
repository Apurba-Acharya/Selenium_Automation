package ex05_XPath_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P3_XPathLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.manage().window().maximize();

        //name:
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");

        //id:
        driver.findElement(By.name("password")).sendKeys("ThisIsNotAPassword");

        //Using "and" operator:
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//button[@id=\"btn-login\" and @class=\"btn btn-default\"]")).click();

        //text():
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//a[text()='Make Appointment']")).click();

        //contains():
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//a[contains(text(),'Make')]")).click();


        driver.navigate().to("https://app.vwo.com/#/login");
        //classname():
        WebElement linkText = driver.findElement(By.className("text-link"));
        linkText.click();

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("244004cjsjcbs");
        WebElement checkbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox.click();

        //tagname():
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();

        //child to parent:
        driver.navigate().to("https://demoqa.com/webtables");
        String header = driver.findElement(By.xpath("//div[@class='rt-tr-group']//parent::div[@class='rt-tbody']//preceding-sibling::div[@class='rt-thead -header']")).getText();
        System.out.println(header);
    }
}
