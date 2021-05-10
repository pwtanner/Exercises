import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import resources.Setup;

public class BrokenLinks extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void brokenLinks() throws IOException {

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        WebElement footer = driver.findElement(By.cssSelector("#gf-BIG"));
        List<WebElement> links = footer.findElements(By.cssSelector("a"));
        SoftAssert a = new SoftAssert();

        for(WebElement link : links){
            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int response = connection.getResponseCode();

            a.assertTrue(response < 400, "The link " + link.getText() + " failed with an error of: " + response + "\n");

        }

        a.assertAll();

        driver.quit();
    }

}
