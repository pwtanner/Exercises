import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;


public class Assignment_4 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void assignment_4() {

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> id = windows.iterator();
        String parentId = id.next();
        String childId = id.next();
        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.xpath("//body/div[1]")).getText());

        driver.switchTo().window(parentId);

        System.out.println(driver.findElement(By.tagName("h3")).getText());

        driver.quit();


    }
}