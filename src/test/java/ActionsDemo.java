import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;


public class ActionsDemo extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void actionsDemo() {

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Actions a = new Actions(driver);

        WebElement helloSignIn = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

        // Moves to specific element
        a.moveToElement(helloSignIn).build().perform();

        // Enter "HELLO" into search text box
        WebElement searchTextbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        a.moveToElement(searchTextbox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        driver.quit();

    }

}
