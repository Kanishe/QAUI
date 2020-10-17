import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class YandexComp {
    private static final Logger logger = LogManager.getLogger(YandexComp.class);
    protected static WebDriver driver;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);


        @Before
        public void setUp() {
            logger.info("Initialized driver");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            logger.info("Started: " + driver);
        }
        @Test
        public void openPage() {
            driver.get(cfg.url());
            logger.info("Open link: " + cfg.url());
            driver.findElement(By.xpath("//a[@href = '/catalog--elektronika/54440']")).click();
            logger.info("Open page 'Elecktronika'");
            driver.findElement(By.xpath("//a[@href = '/catalog--mobilnye-telefony/54726/list?hid=91491']")).click();
            logger.info("Open page 'Mobile'");
            driver.findElement(By.xpath("//span[text()='HUAWEI' and @class = 'NVoaOvqe58']")).click();
            logger.info("Select HUAWEI" );
            driver.findElement(By.xpath("//span[text()='Xiaomi' and @class = 'NVoaOvqe58']")).click();
            logger.info("Select Xiaomi" );
            showMoreWait();
            logger.info("Wait button is clickable");
            driver.findElement(By.xpath("//div[@class = '_3_l6GZZNkG']//button[text()='по цене']")).click();
            logger.info("Sorted HUAWEI and Xiaomi by price");
            showMoreWait();
            driver.findElement(By.xpath("(//span[contains(text(),'HUAWEI')]/ancestor::article/div[@class='_3lszCe6vYR _1ndTjSMyvo']//div[@class ='_1CXljk9rtd'])[1]")).click();
            addProductToComparison();
            driver.findElement(By.xpath("(//span[contains(text(),'Xiaomi')]/ancestor::article/div[@class='_3lszCe6vYR _1ndTjSMyvo']//div[@class ='_1CXljk9rtd'])[1]")).click();
            addProductToComparison();





//            driver.findElement(By.xpath("")).click();

            // assertTrue(driver.getTitle().contains("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям"));
            logger.info(driver.getTitle());
        }



    private static void showMoreWait(){
        new WebDriverWait(driver,10).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = '_8v6CFFrbuZ' ]//button[contains(text(),'Показать ещё')]")));
        logger.info("Button 'see else' available");
    }
    private static void addProductToComparison(){
            if (driver.findElement(By.xpath("//div[@class='nMEoEKZaF-']")).isDisplayed())
                logger.info("Product add to comparing");
    }
        @After
        public void setDown() {
            if (driver != null) {
                driver.quit();
            }
            logger.info("driver shutDown");
        }
}
