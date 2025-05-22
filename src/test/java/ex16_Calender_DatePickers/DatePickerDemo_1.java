package ex16_Calender_DatePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DatePickerDemo_1 {

    static void selectFutureDate(WebDriver driver, String month, String year, String date){

        //Select month and year :
        while(true){
            String currentMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
            String currentYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)){
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //navigate to Next button
        }
        //select the date :
        List <WebElement> allDates = driver.findElements(By.cssSelector(".ui-datepicker-calendar>tbody>tr>td>a"));
        for (WebElement dt:allDates){
            if(dt.getText().equals(date)){
                dt.click();
                break;
            }
        }
    }

    static void selectPastDate(WebDriver driver, String month, String year, String date){

        //Select month and year :
        while(true){
            String currentMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
            String currentYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)){
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //navigate to Next button
        }
        //select the date :
        List <WebElement> allDates = driver.findElements(By.cssSelector(".ui-datepicker-calendar>tbody>tr>td>a"));
        for (WebElement dt:allDates){
            if(dt.getText().equals(date)){
                dt.click();
                break;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");

        //Switch to frame :
        driver.switchTo().frame(0);

        driver.findElement(By.cssSelector("p>#datepicker")).click();
        selectFutureDate(driver,"May", "2026", "10");

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("p>#datepicker")).click();
        selectPastDate(driver,"May", "2025", "10");
    }
}
