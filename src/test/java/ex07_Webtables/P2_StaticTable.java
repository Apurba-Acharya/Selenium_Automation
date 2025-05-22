package ex07_Webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class P2_StaticTable {
    @Test
    public void sTable(){
        ChromeOptions CO = new ChromeOptions();
        CO.addArguments("--headless");
        WebDriver driver = new ChromeDriver(CO);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        //Number of rows:
        List <WebElement> rows = driver.findElements(By.cssSelector("table[name='BookTable']>tbody>tr"));
        int ro = rows.size();
        System.out.println("Number of rows: " + ro);

        //Number of columns:
        List<WebElement> cols = driver.findElements(By.cssSelector("table[name='BookTable']>tbody>tr>th"));
        int co = cols.size();
        System.out.println("Number of columns: " + co);

        //Read data from specific row and columns:
        String specValue = driver.findElement(By.cssSelector("table[name='BookTable']>tbody>tr:nth-of-type(5)>td:nth-of-type(1)")).getText();
        System.out.println("Specific value: " + specValue);

        System.out.println("*******************************************************");

        //Read data from all the rows and columns:
        for (int r=2; r<=ro; r++){
            for (int c=1; c<=co; c++){
                String values = driver.findElement(By.cssSelector("table[name='BookTable']>tbody>tr:nth-of-type("+r+")>td:nth-of-type("+c+")")).getText();
                System.out.print(values + " | ");
            }
            System.out.println();
        }

        System.out.println("*******************************************************");

        //Print book names whose auther is Mukesh:
        for (int r=2; r<=ro; r++){
            String autherName = driver.findElement(By.cssSelector("table[name='BookTable']>tbody>tr:nth-of-type("+r+")>td:nth-of-type(2)")).getText();
            if (autherName.contains("Mukesh")){
                String bName = driver.findElement(By.cssSelector("table[name='BookTable']>tbody>tr:nth-of-type("+r+")>td:nth-of-type(1)")).getText();
                System.out.println(bName + " || " + autherName);
            }
        }

        System.out.println("*******************************************************");

        //Find total price of all the books:
        int total = 0;
        for (int r=2; r<=ro; r++){
            String price = driver.findElement(By.cssSelector("table[name='BookTable']>tbody>tr:nth-of-type("+r+")>td:nth-of-type(4)")).getText();
            total = total+(Integer.parseInt(price));
        }
        System.out.println("Total price of the books: " + total);
    }
}
