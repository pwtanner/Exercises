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


public class DropdownsPractice_2 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownsPractice_2() throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i=0; i<4; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for(WebElement option : options){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }

        Assert.assertEquals(driver.findElement(By.id("autosuggest")).getText(), "India");

        driver.quit();


    }

}
