package ex12_JSExecutor_Imp;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shadow_JS_ScrollByMethod {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0, 500);");
        String url = js.executeScript("return document.URL;").toString();
        String title = js.executeScript("return document.title;").toString();
        System.out.println(url);
        System.out.println(title);
    }
}
