package utils;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseHooks {
    protected static WebDriver driver;
    /**
     * Setup for our driver
    */

    @BeforeEach
    public static void setDriver (){
        driver = WebDriverFactory.createDriver(WebDriveType.CHROME);
        if (driver != null){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }
}
