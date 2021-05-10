import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

import java.io.IOException;


public class DropdownsPractice_3a extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownsPractice_3a() {

        driver.get("http://www.spicejet.com/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // NOTE: Without the window maximization and implicit wait, the script fails.
        // NOTE: The error is: Exception in thread "main" org.openqa.selenium.ElementNotInteractableException: element not interactable

        // Origin
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='DEL']")).click();
        System.out.println("Origin: " + driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).getAttribute("value"));

        // Destination
        driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
        driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
        System.out.println("Destination: " + driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).getAttribute("value"));

        driver.quit();


    }

}
