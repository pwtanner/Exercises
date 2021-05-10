import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

public class Assignment_4b extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void assignment_4b() {

        driver.get("http://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Multiple Windows")).click();

        driver.findElement(By.cssSelector("a[href*='windows']")).click();
        Set<String> abc=driver.getWindowHandles();

        Iterator<String> it=abc.iterator();
        String parentWindow=it.next();
        driver.switchTo().window(it.next());

        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());

        driver.switchTo().window(parentWindow);

        System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());

        driver.quit();

    }

}
