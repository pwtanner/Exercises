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


public class Assignment_2 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void assignment_2()  {

        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.id("PaxBlock")).click();
        WebElement dropdownListAdults = driver.findElement(By.id("Adults"));
        Select adultsDropdown = new Select(dropdownListAdults);
        adultsDropdown.selectByValue("2");

        driver.findElement(By.id("PaxBlock")).click();
        WebElement dropdownListChildren = driver.findElement(By.id("Childrens"));
        Select childrenDropdown = new Select(dropdownListChildren);
        childrenDropdown.selectByValue("7");

        // ui-state-default ui-state-highlight
        driver.findElement(By.id("DepartDate")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight ")).click();

        driver.findElement(By.id("MoreOptionsLink")).click();
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("United Airlines");

        driver.findElement(By.id("SearchBtn")).click();

        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

        driver.quit();

    }

}
