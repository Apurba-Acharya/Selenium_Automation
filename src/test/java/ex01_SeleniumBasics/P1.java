package ex01_SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class P1 {
    @Test
    public void test_selenium01(){
        EdgeDriver driver = new EdgeDriver();
        WebDriverManager.edgedriver().setup(); // This will compile the local edge version with script
        driver.get("https://app.vwo.com");
        System.out.println();
    }
}
