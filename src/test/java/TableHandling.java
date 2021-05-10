import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;



public class TableHandling extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void tableHandling() {

        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,650)");

        List<WebElement> row = driver.findElements(By.xpath("//table[@name=\"courses\"]/tbody/tr"));

        System.out.println("No of rows=" + row.size());

        List<WebElement> Col = driver.findElements(By.xpath("//table[@name=\"courses\"]/tbody/tr/th"));

        System.out.println("No of rows=" + Col.size());

        System.out.println(driver.findElement(By.xpath("//table[@name=\"courses\"]/tbody/tr[3]")).getText());

        driver.quit();

    }

}

