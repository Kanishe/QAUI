package cases;

import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.LoginPage;

import java.util.concurrent.TimeUnit;

public class OtusLogin {
    protected static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(OtusLogin.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);


    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions op = new ChromeOptions();
        driver = new ChromeDriver(op);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Driver is setup");
    }

    @Test
    public void openPage(){
        driver.get(cfg.url());
        logger.info("Otus main page is open - " + driver.getCurrentUrl());

    }

    @AfterEach
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("Driver shutDown");
    }
}
