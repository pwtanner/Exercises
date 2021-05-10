import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;


public class StreamsTest_7a extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void streamsTest_7a() {

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String item = "erry";

        driver.findElement(By.cssSelector("#search-field")).sendKeys(item);

        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredList = veggies.stream().filter(veggie->veggie.getText().contains(item)).collect(Collectors.toList());

        System.out.println("Veggies (size): " + veggies.size());
        System.out.println("Filtered List (size): " + filteredList.size());

        Assert.assertEquals(veggies.size(), filteredList.size());

        driver.quit();

    }

}
