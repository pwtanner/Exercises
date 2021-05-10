import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;


public class Assignment_5 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void assignment_5() {

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("a[href*='nested']")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//frameset[1]/frame[1]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//frameset[1]/frame[2]")));

        System.out.println(driver.findElement(By.id("content")).getText());

        driver.quit();


    }
}
