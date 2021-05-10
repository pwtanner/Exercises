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


public class StreamsTest_5 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void streamsTest_5() {

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> originalItemsList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());

        List<String> sortedItemsList = originalItemsList.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(originalItemsList.equals(sortedItemsList));

        driver.quit();


    }

}
