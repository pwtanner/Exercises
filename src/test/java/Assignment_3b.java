import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

import java.io.IOException;

public class Assignment_3b extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void assignment_3b() {

        // TODO Auto-generated method stub
        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

        driver.findElement(By.cssSelector("a[href*='loadAjax']")).click();

        WebDriverWait d=new WebDriverWait(driver,20);

        d.until(ExpectedConditions.elementToBeClickable(By.id("results")));

        System.out.println(driver.findElement(By.id("results")).getText());

        //  System.out.println( driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText());


    }

}
