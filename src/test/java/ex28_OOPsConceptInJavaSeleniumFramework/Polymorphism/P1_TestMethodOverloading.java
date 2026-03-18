package ex28_OOPsConceptInJavaSeleniumFramework.Polymorphism;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_TestMethodOverloading {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        P1_BaseMethodOverloading act = new P1_BaseMethodOverloading(driver);
        act.action(By.id("loginBtn"));
        act.action(By.id("username"), "apurba");
        act.action(By.id("search"), "selenium", true);
    }
}