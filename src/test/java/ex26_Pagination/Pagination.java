package ex26_Pagination;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Pagination {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.clear();
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.clear();
        password.sendKeys("demo");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

//        if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()){
//                driver.findElement(By.xpath("//button[@class='btn-close']")).click();
//        }
        driver.findElement(By.cssSelector("#menu-customer>a")).click();
        driver.findElement(By.cssSelector("#collapse-5>li:nth-of-type(1)>a")).click();

        String text = driver.findElement(By.cssSelector("#customer>form>div:nth-of-type(2)>div:nth-of-type(2)")).getText();
        int total_pages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));

        //Repeating pages :
        for (int p=1; p<=total_pages; p++){ //total_pages
            Thread.sleep(2000);
            if(p>1){
                WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()='"+p+"']")); //CSS
                active_page.click();
            }
        }
        int noOfrows = driver.findElements(By.cssSelector(".table-bordered>tbody>tr")).size();
        for (int i = 1; i <= noOfrows; i++) {
            try {
                String customer_name = driver.findElement(By.cssSelector(".table-bordered>tbody>tr:nth-of-type(" + i + ")>td:nth-of-type(2)")).getText();
                String customer_email = driver.findElement(By.cssSelector(".table-bordered>tbody>tr:nth-of-type(" + i + ")>td:nth-of-type(3)")).getText();
                String customer_action = driver.findElement(By.cssSelector(".table-bordered>tbody>tr:nth-of-type(" + i + ")>td:nth-of-type(5)")).getText();

                System.out.println(customer_name + "\t" + customer_email + "\t" + customer_action);
            } catch (StaleElementReferenceException e) {
                System.out.println("Element became stale, reloading...");
                i--; // Retry the same index
            }
        }
    }
}
