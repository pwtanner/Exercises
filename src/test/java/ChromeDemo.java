import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

import java.io.IOException;


public class ChromeDemo extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void chromeDemo(){

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());

        driver.quit();
    }

}
