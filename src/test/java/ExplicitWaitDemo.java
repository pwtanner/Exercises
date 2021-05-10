import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

public class ExplicitWaitDemo extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void explicitWaitDemo() {

        driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.manage().window().maximize();

        WebDriverWait w = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']")));

        System.out.println(driver.findElement(By.xpath("//div[@id='results']")).getText());

        driver.quit();


    }

}
