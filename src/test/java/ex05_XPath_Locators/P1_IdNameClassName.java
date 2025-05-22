package ex05_XPath_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P1_IdNameClassName {
    @Test
    public void selenium01 () throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");

        // 1. Find email input box
        // <input >> Open HTML tag
        // type="email"
        // class="text-input W(100%)"
        // name="username"
        // id="login-username"
        // data-qa="hocewoqisi"
        // > Close HTML tag

        WebElement emailinput = driver.findElement(By.id("login-username"));
        emailinput.sendKeys("admin@admin.com");

        // 2. Find the password input box
        //<input
        // type="password"
        // class="text-input W(100%)"
        // name="password"
        // id="login-password"
        // data-qa="jobodapuxe">

        WebElement passwordinput = driver.findElement(By.name("password"));
        passwordinput.sendKeys("xyxyxyxy");

        // 3. Find the button and click on it
        //<button
        // type="submit"
        // id="js-login-btn"
        // class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)"
        // onclick="login.login(event)"
        // data-qa="sibequkica">
        // class="icon loader hidden"
        // data-qa="zuyezasugu"></span>
        //	data-qa="ezazsuguuy"
        //	>

        WebElement submitbutton = driver.findElement(By.id("js-login-btn"));
        submitbutton.click();

        //4. Find the invalid error message and verify
        //<div
        // class="notification-box-description"
        // id="js-notification-box-msg"
        // data-qa="rixawilomi">
        // Your email, password, IP address or location did not match</div>
        Thread.sleep(3000);
        WebElement error = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error.getText(),"Your email, password, IP address or location did not match");

        Thread.sleep(5000);
        driver.quit();
    }
}
