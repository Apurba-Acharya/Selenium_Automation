package ex07_Webtables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class P1_ExtractTableValue {
    @Test
    @Description ("Test Case Description")
    public void test_web_table_login() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

        String st1 = "//table[@id=\"customers\"]/tbody/tr[";
        String st2 = "]/td[";
        String st3 = "]";

        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        for (int i=2; i<=row; i++ ){
            for (int j=1; j<=col; j++){
                String dynamic_path = st1+i+st2+j+st3;
                //System.out.println(dynamic_path);
                String data = driver.findElement(By.xpath(dynamic_path)).getText();
                //System.out.println(data);
                if (data.contains("Helen Bennett")){
                    String country_Xpath = dynamic_path +"/following-sibling::td";
                    String country_text = driver.findElement(By.xpath(country_Xpath)).getText();
                    System.out.println("Helen Bennett is In - " + country_text);
                }
            }
        }
    }
}
