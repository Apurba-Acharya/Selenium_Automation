package ex05_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class P6_CSS {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // CSS 1 : ID: htmltag#id || #id
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("Trouser");
        Thread.sleep(1000);

        // CSS 2: CLASS
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("input.search_query")).sendKeys("T-Shirts");
        Thread.sleep(1000);

        // CSS 3: multiple classes and id
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("input.search_query.form-control.ac_input#search_query_top")).sendKeys("Shirt");
        Thread.sleep(1000);

        // CSS 4: attribute equals: tag[attribute='value']
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("a[class='login']")).click();
        Thread.sleep(1000);

        // CSS 5: multiple attributes
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("input[id='search_query_top'][name='search_query']")).sendKeys("VSCode");
        Thread.sleep(1000);

        // CSS 6: contains: tag[attribute*='value']
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("input[class*='search']")).sendKeys("DellTech");
        Thread.sleep(1000);

        // CSS 7: starts with
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("input[class^='sear']")).sendKeys("HpTechnology");
        Thread.sleep(1000);

        // CSS 8: ends with
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("input[id$='top']")).sendKeys("LenovoSlim");
        Thread.sleep(1000);

        // CSS 9: multiple selectors
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("input.search_query,input#search_query_top")).sendKeys("LenovoSlim");
        Thread.sleep(1000);

        // CSS 10: nth-of-type
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("div#htmlcontent_home>ul>li:nth-of-type(3)")).click();
        Thread.sleep(1000);

        // CSS 11: sibling selector
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("div.block_content>ul>li:nth-of-type(1)+li+li")).click();
        Thread.sleep(1000);

        // CSS 12: contains() in attribute
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("a[title*='Wom']")).click();
        Thread.sleep(1000);

        driver.quit();
    }
}
