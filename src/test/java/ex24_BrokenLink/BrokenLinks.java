package ex24_BrokenLink;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Broken link : Is a link which does not have any resource in the server.


public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Number of links: " + links.size());

        Set<String> uniqueLinks = new HashSet<>(); // To track unique href values
        int numberOfbrokenLinks = 0;
        int numberOfDuplicateLinks = 0;

        for (WebElement linkElement : links) {
            String hrfattvalue = linkElement.getAttribute("href");

            if (hrfattvalue == null || hrfattvalue.isEmpty()) {
                System.out.println("href attribute value is null or empty. Not possible to check");
                continue;
            }

            if (!uniqueLinks.add(hrfattvalue)) {
                numberOfDuplicateLinks++; // Count the duplicate
                continue;
            }

            // Hit URL to the server:
            try {
                URL linkURL = new URL(hrfattvalue); // Convert href value from string to URL format
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection(); // Open the connection to the server
                conn.connect(); // Connect to the server and send request

                if (conn.getResponseCode() >= 400) {
                    System.out.println(hrfattvalue + " > Broken link : " + conn.getResponseCode() + " :: " + conn.getResponseMessage());
                    numberOfbrokenLinks++;
                } else {
                    System.out.println(hrfattvalue + " > Not a broken link : " + conn.getResponseCode() + " :: " + conn.getResponseMessage());
                }
            } catch (Exception e) {
                // Optionally log the exception if needed
            }
        }

        System.out.println("Number of broken links : " + numberOfbrokenLinks);
        System.out.println("Number of duplicate links skipped : " + numberOfDuplicateLinks);
    }

}
