package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory{
   // private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
    public static WebDriver createDriver(WebDriveType webDriveType){
        switch (webDriveType){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case OPERA:
                WebDriverManager.operadriver().setup();
                return new SafariDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver();
                return new FirefoxDriver();
            default:
                return null;
        }
    }
}
