import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

import java.io.IOException;


public class Assignment_5b extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void assignment_5b() {

        driver.get("http://the-internet.herokuapp.com");

        driver.findElement(By.linkText("Nested Frames")).click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name*='frame-top']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src*='frame_middle']")));

        //driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        //driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));

        //driver.switchTo().frame(driver.findElement(By.name("frame-top")));
        //driver.switchTo().frame(driver.findElement(By.name("frame-middle")));

        System.out.println(driver.findElement(By.id("content")).getText());

        driver.quit();

    }

}
