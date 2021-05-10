import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;


public class LimitingScope extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void limitingScope() {

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Links in the entire page


        // Links in the footer section
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        System.out.println("The number of links in the footer is: " + footer.findElements(By.tagName("a")).size());

        // Links in the first column in the footer section
        WebElement firstColumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println("The number of links in the footer is: " + firstColumn.findElements(By.tagName("a")).size());

        // Click on links in the first column
        for(int i=1; i<firstColumn.findElements(By.tagName("a")).size(); i++) {
            String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);

        }

        driver.quit();

    }

}
