import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;


public class Calendar extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void calendar() {

        driver.get("https://www.path2usa.com/travel-companions");
        driver.manage().window().maximize();

        // August 23
        driver.findElement(By.id("travel_date")).click();

        while(driver.findElement(By.cssSelector("[class = 'datepicker-days'] [class = 'datepicker-switch']")).getText().contains("August")){

        }

        // //body[1]/div[8]/div[1]/table[1]/thead[1]/tr[1]/th[3]

        List<WebElement> days = driver.findElements(By.className("day"));
        int count = days.size();
        for(int i=0; i < count; i++){
            String text = days.get(i).getText();
            if(text.equalsIgnoreCase("23")){
                days.get(i).click();
                break;
            }
        }

        driver.quit();

    }
}
