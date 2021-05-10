import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class EdgeDemo {

    public static void main(String[] args){

        System.setProperty("webdriver.edge.driver", "C:\\Selenium 3 Jars and Drivers\\Drivers\\msedgedriver.exe");
        WebDriver webDriver = new EdgeDriver();
        webDriver.get("https://www.google.com/");
        System.out.println(webDriver.getTitle());


    }

}
