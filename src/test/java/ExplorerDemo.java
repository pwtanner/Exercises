import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ExplorerDemo {

    public static void main(String[] args){

        System.out.println("Got here 1.");
        System.setProperty("webdriver.ie.driver", "C:\\Selenium 3 Jars and Drivers\\Drivers\\IEDriverServer.exe");
        System.out.println("Got here 2.");
        WebDriver webDriver = new InternetExplorerDriver();
        System.out.println("Got here 3.");
        webDriver.get("https://www.google.com/");
        System.out.println("Got here 4.");
        System.out.println(webDriver.getTitle());
        System.out.println("Got here 5.");


    }

}
