package ex05_XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class P4_XPathAxes {
    WebDriver driver = new ChromeDriver();

    @Test(priority = 1)
    public void XPathAxes1(){
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        driver.findElement(By.xpath("//div[@class=\"form-group\"][3]//parent::form")); // Parent

        driver.findElement(By.xpath("//form[@class=\"form-horizontal\"]//child::div[3]")); // Child

        driver.findElement(By.xpath("//form[@class=\"form-horizontal\"]//descendant::label[3][@for=\"txt-password\"]")); // Descendant

        driver.findElement(By.xpath("//label[@for=\"txt-password\"]//ancestor::form")); // Ancestor
        // Or, Ancestor : //label[@for="txt-password"]//ancestor::*

        driver.findElement(By.xpath("//form[@class=\"form-horizontal\"]//descendant::input[2]")); // Descendant

        driver.findElement(By.xpath("//div[@class=\"form-group\"]//following::span[3]")); // Following
        // Or, Following :
        // label[@for="txt-password"]//following::*
        // div[@class="form-group"]//following::span[first()]
        // div[@class="form-group"]//following::span[last()]

        driver.findElement(By.xpath("//div[@class=\"form-group\"]//following::span[3]")); // Following

        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.xpath("//input[@id=\"login-password\"]//preceding::input")); // Preceding

        driver.findElement(By.xpath("//li[@data-qa=\"kopecopeqa\"]//following-sibling::li")); // Following-sibling

        driver.findElement(By.xpath("//li[@data-qa=\"kopecopeqa\"]//preceding-sibling::li[2]")); // Preceding-sibling

        //For dynamic XPath we can use the following structure:
        //tagname[contains(@attribute,"value")]
        //*[contains(@attribute,"value")]
        //tagname[starts-with(@attribute,"value")]
    }

    @Test (priority = 2)
    public void XPathAxes2(){
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

        // Following-sibling:
        driver.findElement(By.xpath("//label[text()=\"Email\"]/following-sibling::input[1]"));

        // Parent:
        driver.findElement(By.xpath("//label[text()=\"Email\"]/parent::div"));

        // Child:
        driver.findElement(By.xpath("//div[@class=\"container\"]/child::input[@type=\"text\"]"));

        // Preceding-sibling:
        driver.findElement(By.xpath("//td[text() = \"Maria Anders\"]/preceding-sibling::td/child::input"));

        // Descendant:
        driver.findElement(By.xpath("//div[@class=\"container\"]/descendant::button"));

        // Ancestor
        driver.findElement(By.xpath("//div[@class=\"buttons\"]/ancestor::div"));

        // Ancestor-or-self: It will include current element also.
        driver.findElement(By.xpath("//div[@class=\"buttons\"]/ancestor-or-self::div"));

        //Following:
        driver.findElement(By.xpath("//label[text()=\"Password\"]/following::input[2]"));

        //Preceding:
        driver.findElement(By.xpath("//label[text()=\"Password\"]/preceding::input[2]"));
    }
}
