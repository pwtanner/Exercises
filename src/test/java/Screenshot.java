import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

public class Screenshot extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void screenshot() throws IOException {

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("F:\\Users\\Paul\\Desktop\\screenshot.png"));

        driver.quit();


    }

}
