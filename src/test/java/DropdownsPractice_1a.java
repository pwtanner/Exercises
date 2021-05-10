import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;


public class DropdownsPractice_1a extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownsPractice_1a() {

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Origin
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='DEL']")).click();
        System.out.println("Origin: " + driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).getAttribute("value"));

        // Destination
        driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
        driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
        System.out.println("Destination: " + driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).getAttribute("value"));

        // Departure Date
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        // Numbers of Passengers
        WebElement passengersDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));

        // Dropdown with select tag
        WebElement dropdownListCurrency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select currencyDropdown = new Select(dropdownListCurrency);

        currencyDropdown.selectByIndex(3);
        System.out.println(currencyDropdown.getFirstSelectedOption().getText());
        Assert.assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "INR");

        currencyDropdown.selectByVisibleText("AED");
        System.out.println(currencyDropdown.getFirstSelectedOption().getText());
        Assert.assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "AED");

        currencyDropdown.selectByValue("USD");
        System.out.println(currencyDropdown.getFirstSelectedOption().getText());
        Assert.assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "USD");

        /*
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i=0; i<4; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

         */

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }

        //Assert.assertEquals(driver.findElement(By.id("autosuggest")).getText(), "India");

        driver.quit();

    }

}
