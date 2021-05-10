import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;


public class Assignment_8 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void assignment_8() {

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("Aus");

        List<WebElement> countries = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));

        for(WebElement country : countries){
            if(country.getText().equalsIgnoreCase("Austria")){
                country.click();
                break;
            }
        }

        String result = driver.findElement(By.id("autocomplete")).getAttribute("value");

        Assert.assertEquals(result, "Austria");

        driver.quit();


    }
}
