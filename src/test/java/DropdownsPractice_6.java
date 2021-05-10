import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;


public class DropdownsPractice_6 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownsPractice_6() {

        driver.get("http://www.spicejet.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Click the "Round Trip" radio button
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

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
        driver.findElement(By.id("divpaxinfo")).click();
        WebElement dropdownListPassengers = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
        Select passengersDropdown = new Select(dropdownListPassengers);
        passengersDropdown.selectByValue("5");


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

        // Click the "Family and Friends" checkbox
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

        // Click the "Find Flights" button
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

        driver.quit();

    }

}
