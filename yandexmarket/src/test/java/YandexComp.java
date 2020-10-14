import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class YandexComp {
    private final Logger logger = LogManager.getLogger(YandexComp.class);
    protected static WebDriver driver;


        @Before
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("WARNINNNNNNNNNNNNNN");
            logger.warn("warrrrrrr");
        }
        @Test
        public void openPage() {
            driver.get("https://otus.ru/");
            logger.info("Открыта страница отус");
            assertTrue(driver.getTitle().contains("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям"));
            logger.info(driver.getTitle());
        }
        @After
        public void setDown() {
            if (driver != null) {
                driver.quit();
            }
            logger.info("ddddddd");
        }
}
