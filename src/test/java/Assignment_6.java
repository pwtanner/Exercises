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


public class Assignment_6 extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void assignment_6()  {

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        Random random = new Random();
        int x = random.nextInt(3) + 1;
        String index = String.valueOf(x);

        String checkboxId = "checkBoxOption" + index;

        driver.findElement(By.id(checkboxId)).click();

        String labelPath = "//body/div[1]/div[4]/fieldset[1]/label[" + index + "]";

        String labelName = driver.findElement(By.xpath(labelPath)).getText();

        driver.findElement(By.id("dropdown-class-example"));

        Select selectOptions = new Select(driver.findElement(By.id("dropdown-class-example")));

        List<WebElement> options = selectOptions.getOptions();

        for(WebElement option : options){
            if(option.getText().equalsIgnoreCase(labelName)){
                option.click();
                break;
            }
        }

        driver.findElement(By.id("name")).sendKeys(labelName);
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertTrue(driver.switchTo().alert().getText().contains(labelName));

        driver.quit();

    }
}
