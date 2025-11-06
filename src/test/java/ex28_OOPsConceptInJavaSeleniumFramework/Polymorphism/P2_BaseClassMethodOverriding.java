package ex28_OOPsConceptInJavaSeleniumFramework.Polymorphism;

/* Method Overriding/Runtime Polymorphism/Late Binding/Dynamic Binding:
        •Declaring a method in child class which already present in parent class.
        •Subclass provides a new implantation for a method in superclass. */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class P2_BaseClassMethodOverriding {
    WebDriver driver;
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }
    public void closeBrowser() {
        driver.quit();
    }
}

class TestBrowserMethodOverriding extends P2_BaseClassMethodOverriding {
    @Override
    public void openBrowser() throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("-InPrivate");
        driver = new EdgeDriver(options);
        driver.get("https://www.OrangeHRM.com");
        Thread.sleep(5000);
    }
}
