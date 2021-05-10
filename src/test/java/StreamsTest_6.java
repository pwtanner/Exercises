import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;


public class StreamsTest_6 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void streamsTest_6() {

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String item = "Rice";

        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<String> price;

        do{
            List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

            List<String> itemsList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

            price = elementsList.stream().filter(s -> s.getText().equalsIgnoreCase(item)).map(s -> getPrice(s)).collect(Collectors.toList());
            if(price.size() < 1){
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        } while(price.size() < 1);

        System.out.println("The price for " + item + " is: " + price.get(0));

        driver.quit();

    }

    private static String getPrice(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

}
