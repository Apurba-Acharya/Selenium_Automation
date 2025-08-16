package ex05_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class P5_amazonXPathAxes {

    WebDriver driver;

    // Before click wait element method:
    public void clickWithDelay(WebElement element, int delayInSeconds) {
        try {
            Thread.sleep(delayInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.click();
    }

    @Test
    public void amazonXPath() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert soft = new SoftAssert();

        String brandName = "OPPO";
        String prodC = "OPPO A5X 4G (Laser White, 4GB RAM, 128GB Storage) with Exchange Bonus or No Cost EMI";

        try {
            // Continue shopping button:
            WebElement continueBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'a-button-inner')]//button")));
            if (continueBtn.getText().equalsIgnoreCase("Continue shopping")) {
                continueBtn.click();
            }
        } catch (TimeoutException e) {
            System.out.println("'Continue shopping' button not found, proceeding to search...");
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Search Amazon.in']/following-sibling::input"))).sendKeys("Phones");
            driver.findElement(By.xpath("//span[@aria-label='Go']/child::input")).click();

            // Check if brand is in the initial list
            List<WebElement> brands = driver.findElements(By.xpath("//div[@id='brandsRefinements']/descendant::span[2]/child::span/descendant::span[1]/child::a"));
            boolean brandFound = false;
            for (WebElement brand : brands) {
                if (brand.getText().equalsIgnoreCase(brandName)) {
                    brand.click();
                    brandFound = true;
                    break;
                }
            }

            // If brand not found, click "See more" and search again
            if (!brandFound) {
                WebElement seeMore = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@aria-label, \"Brands\")]/descendant::span[text()=\"See more\"]")));seeMore.click();

                // Wait for expanded list
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#brandsRefinements>ul>[role=\"presentation\"]>li>span>div>div>ul>span>li>span>a")));
                List<WebElement> moreBrands = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='brandsRefinements']/descendant::li[8]/descendant::ul/descendant::a")));
                for (WebElement brand : moreBrands) {
                    if (brand.getText().equalsIgnoreCase(brandName)) {
                        brand.click();
                        break;
                    }
                }
            }
        } catch (TimeoutException e) {
            System.out.println("Search or brand selection elements not found, skipping...");
        }

        // SortBy button:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"a-dropdown-container\"]/descendant::span[2]"))).click();
        List<WebElement> sortBy = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".a-nostyle.a-list-link>li>a")));
        for (WebElement sorted : sortBy) {
            if (sorted.getText().equalsIgnoreCase("Newest Arrivals")) {
                sorted.click();
                break;
            }
        }

        // List Of products:
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@class, \"s-main-slot s-result-list s-search-results sg-row\")]" + "/div[contains(@role, \"listitem\")]/descendant::span[3]")));
        boolean found = false;
        for (WebElement prdts : products) {
            if (prdts.getText().equalsIgnoreCase(prodC)) {
                clickWithDelay(prdts, 5);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found from the list...");
        }
        String selProd = driver.findElement(By.xpath("//*[contains(@id, \"centerCol\")]/descendant::span[@id=\"productTitle\"]")).getText().trim();
        soft.assertEquals(selProd, prodC);

        //Add-To-Cart button:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, \"a-spacing-none a-padding\")]//descendant::input[contains(@id, \"add-to-cart-button\")]"))).click();
        //Proceed to checkout button:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@name, \"proceedToRetailCheckout\")]"))).click();

        //Sign-in page:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, \"email_login\")]"))).sendKeys("arpita6079@gmail.com");
        WebElement loginEmail = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        clickWithDelay(loginEmail, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type*=\"password\"]"))).sendKeys("Arpita@6079");
        WebElement loginPass = driver.findElement(By.cssSelector("input[id*=\"signIn\"]"));
        clickWithDelay(loginPass, 5);
    }
}
