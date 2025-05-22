package ex18_Selenium_AlertsBox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class A3_AlertsAuthenticationPopUp {
    @Test
    public void alerts(){
        WebDriver driver = new ChromeDriver();

        //Syntax: http://username:password@the-internet.herokuapp.com/basic_auth
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
