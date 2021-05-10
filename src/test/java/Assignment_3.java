import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

import java.io.IOException;

public class Assignment_3 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void assignment_3() {

        driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.manage().window().maximize();

        WebDriverWait w = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']")));

        System.out.println(driver.findElement(By.xpath("//div[@id='results']")).getText());

        driver.quit();



    }

}
