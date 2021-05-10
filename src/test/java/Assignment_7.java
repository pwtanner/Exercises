import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;


public class Assignment_7 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void assignment_7() {

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        int headerRowsCount = driver.findElements(By.cssSelector("table#product.table-display th:nth-child(3)")).size();
        int dataRowsCount = driver.findElements(By.cssSelector("table#product.table-display td:nth-child(3)")).size();

        int totalRowsCount = headerRowsCount + dataRowsCount;
        System.out.println("The total number of rows in the Web Table is: " + totalRowsCount);

        System.out.println("The total number of columns in the Web Table is: "
                + driver.findElements(By.cssSelector("table#product.table-display th")).size());

        List<WebElement> instructors = driver.findElements(By.cssSelector("table#product.table-display td:nth-child(1)"));
        List<WebElement> courses = driver.findElements(By.cssSelector("table#product.table-display td:nth-child(2)"));
        List<WebElement> prices = driver.findElements(By.cssSelector("table#product.table-display td:nth-child(3)"));

        System.out.println(instructors.get(2).getText() + " --> " + courses.get(2).getText() + " --> $" + prices.get(2).getText());

        driver.quit();

    }
}
