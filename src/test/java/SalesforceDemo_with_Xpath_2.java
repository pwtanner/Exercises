import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

import java.io.IOException;


public class SalesforceDemo_with_Xpath_2 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void salesforceDemoWithXpath_2() throws InterruptedException {

        driver.get("https://login.salesforce.com/");

        driver.findElement(By.xpath("//input[contains(@id,'usernam')]")).sendKeys("abcdefg@gmail.com");
        driver.findElement(By.xpath("//input[contains(@id,'passwor')]")).sendKeys("123456");
        driver.findElement(By.xpath("//input[contains(@id,'Logi')]")).click();

        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div[@id=\'error\']")).getText());

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id=\'error\']")).getText(),
                "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");

        driver.quit();

    }

}

