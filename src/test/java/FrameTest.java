import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

import java.io.IOException;

public class FrameTest extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void frameTest() {

        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        System.out.println("The number of frames is: " + driver.findElements(By.tagName("iframe")).size());

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        Actions a = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target).build().perform();

        System.out.println(driver.findElement(By.id("droppable")).getText());

        driver.switchTo().defaultContent();

        driver.quit();

    }
}
