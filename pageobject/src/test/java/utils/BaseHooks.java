package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseHooks {
    private static final Logger logger = LogManager.getLogger(BaseHooks.class);
    //private static final Logger logger = LogManager.getLogger(YandexComp.class);
    protected static WebDriver driver;
    /**
     * Setup for our driver
    */

    @BeforeAll
    public static void setDriver (){
        driver = WebDriverFactory.createDriver(WebDriveType.CHROME);
        if (driver != null){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            logger.info("Driver start - " + driver);
        }
    }
/**
 * ShotDown driver
 */
    @AfterAll
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
    /**
     * ShotDown driver
     */
    @AfterEach
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }
}
