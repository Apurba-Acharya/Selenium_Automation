package ex10_Windowsandiframe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class test28_windowHandleUsingArraylistAndforloop {
        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.redbus.in/");
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(By.xpath("//span[@class='footer_copyright_text']"));
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(5000);

            // Store the main window handle
            String mainWindow = driver.getWindowHandle();
            System.out.println("Parent window ID: " + mainWindow);

            // List to maintain the order of window handles
            List<String> windowOrder = new ArrayList<>();
            windowOrder.add(mainWindow);

            // Click each element and immediately capture the new window handle
            clickAndStoreWindow(driver, "//img[@alt='redbus_twitter']", windowOrder);
            clickAndStoreWindow(driver, "//img[@alt='redbus_linkedin']", windowOrder);
            clickAndStoreWindow(driver, "//img[@alt='redbus_instagram']", windowOrder);
            clickAndStoreWindow(driver, "//img[@alt='redbus_facebook']", windowOrder);

            // Print URLs in the correct order
            for (String window : windowOrder) {
                driver.switchTo().window(window);
                System.out.println("URL: " + driver.getCurrentUrl());
            }

            // Close all tabs except the main one
            for (String window : windowOrder) {
                if (!window.equals(mainWindow)) {
                    driver.switchTo().window(window);
                    driver.close();
                }
            }

            // Switch back to the main window
            driver.switchTo().window(mainWindow);
        }

        private static void clickAndStoreWindow(WebDriver driver, String xpath, List<String> windowOrder) throws InterruptedException {
            driver.findElement(By.xpath(xpath)).click();
            Thread.sleep(2000); // Wait for the new tab to open

            // Capture newly opened window
            Set<String> allWindows = driver.getWindowHandles();
            for (String handle : allWindows) {
                if (!windowOrder.contains(handle)) {
                    windowOrder.add(handle);
                    break; // Ensure we only add one new window per click
                }
            }
        }
    }
