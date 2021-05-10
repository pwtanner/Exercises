import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxDemo {

    public static void main(String[] args){

        System.setProperty("webdriver.firefox.driver", "C:\\Selenium 3 Jars and Drivers\\Drivers\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.google.com/");
        System.out.println(webDriver.getTitle());


    }

}
