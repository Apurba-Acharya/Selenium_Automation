package ex11_1_Actions_Advance_FileUpload_DragDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class test31_Actions_FileUpload_DragDrop_P7 {
    @Test
    public void p7() throws InterruptedException {
//         EdgeOptions Options = new EdgeOptions();
//         Options.addArguments("--InPrivate");
//
////        ChromeOptions Options = new ChromeOptions();
////        Options.addArguments("--Ingognito");
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/selenium/upload.html");
        driver.manage().window().maximize();
        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));

        String dir = System.getProperty("user.dir");
        System.out.println("Print the file location directory: " + dir);

        //file upload >>
        uploadFileInput.sendKeys("C:\\Users\\APURBA ACHARYA\\IdeaProjects\\LearningSeleniumATB9x\\src\\test\\java\\com\\apurba\\in\\ex11_1_Actions_Advance_FileUpload_DragDrop\\hello.txt");
        Thread.sleep(3000);
        driver.findElement(By.name("submit")).click();

        //Drag & Drop >>
        Thread.sleep(5000);
        driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(from,to).perform();
        //Or >>
        //actions.clickAndHold(from).moveToElement(to).release(to).build().perform();
    }
}