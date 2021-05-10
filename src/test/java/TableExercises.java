import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Setup;

import java.io.IOException;

public class TableExercises extends Setup {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void tableExercises() {

        int sum=0;

        driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");
        driver.manage().window().maximize();

        WebElement table=driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        //int rowcount= table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
        int count=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

        for(int i=0;i<count-2;i++)
        {
            String value=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
            int valueinteger=  Integer.parseInt(value);
            sum=sum+valueinteger;//103
        }
        //System.out.println(sum);

        String Extras=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
        int extrasValue=Integer.parseInt(Extras);
        int TotalSumValue=sum+extrasValue;
        System.out.println(TotalSumValue);


        String ActualTotal=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        int ActualTotalValue=Integer.parseInt(ActualTotal);
        if(ActualTotalValue==TotalSumValue)
        {
            System.out.println("Count Matches");
        }
        else
        {
            System.out.println("count fails");
        }

        driver.quit();
    }

}
