import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

import java.io.IOException;


public class SalesforceDemo_with_CSS_1 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void salesforceDemoWithCss_1() throws InterruptedException {

        driver.get("https://login.salesforce.com/");

        driver.findElement(By.cssSelector("input[id=\'username\']")).sendKeys("abcdefg@gmail.com");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[id=\'Login\']")).click();

        Thread.sleep(1000);
        System.out.println(driver.findElement(By.cssSelector("div[id=\'error\']")).getText());

        driver.quit();

    }

}
