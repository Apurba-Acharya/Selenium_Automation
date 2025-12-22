package ex29_FullPageScreenShorts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class fullPageScreenShorts {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new EdgeDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void test_FullPage() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://sdet.to/");

        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);

        ImageIO.write(screenshot.getImage(), "jpg",
                new File("./fullimage.jpg"));
    }

    @Test
    public void test_OnlyElement() throws IOException {
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();

        WebElement myWebElement = driver.findElement(By.id("file-upload"));

        Screenshot elementShot = new AShot()
                .takeScreenshot(driver, myWebElement);

        ImageIO.write(elementShot.getImage(), "jpg",
                new File("./element.jpg"));
    }
}