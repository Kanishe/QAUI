import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YandexComp {
    private static final Logger logger = LogManager.getLogger(YandexComp.class);
    protected static WebDriver driver;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);


    @Before
    public void setUp() {
        logger.info("Initialized driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Started: " + driver);
    }

    @Test
    public void openPage() throws InterruptedException {
        driver.get(cfg.url());
        logger.info("Open link: " + cfg.url());
        driver.findElement(By.xpath("//a[@href = '/catalog--elektronika/54440']")).click();
        logger.info("Open page 'Elecktronika'");
        driver.findElement(By.xpath("//a[@href = '/catalog--mobilnye-telefony/54726/list?hid=91491']")).click();
        logger.info("Open page 'Mobile'");
        driver.findElement(By.xpath("//span[text()='HUAWEI' and @class = 'NVoaOvqe58']")).click();
        logger.info("Select HUAWEI");
        driver.findElement(By.xpath("//span[text()='Xiaomi' and @class = 'NVoaOvqe58']")).click();
        logger.info("Select Xiaomi");
        showMoreWait();
        logger.info("Wait button is clickable");
        driver.findElement(By.xpath("//div[@class = '_3_l6GZZNkG']//button[text()='по цене']")).click();
        logger.info("Sorted HUAWEI and Xiaomi by price");
        showMoreWait();
        driver.findElement(By.xpath("(//span[contains(text(),'HUAWEI')]/ancestor::article/div[@class='_3lszCe6vYR _1ndTjSMyvo']//div[@class ='_1CXljk9rtd'])[1]")).click();
        addProductToComparison();
        driver.findElement(By.xpath("(//span[contains(text(),'Xiaomi')]/ancestor::article/div[@class='_3lszCe6vYR _1ndTjSMyvo']//div[@class ='_1CXljk9rtd'])[1]")).click();
        addProductToComparison();
        waitComparisonButton();
        logger.info("We open comparison page");
        List listOfProducts = driver.findElements(By.xpath("//div[@class='LwwocgVx0q zvRJMhRW-w']"));
        logger.info("In comparison page we have "+listOfProducts.size()+" product");
        driver.findElement(By.xpath("//div[@class='_2bm8juabMn']//button[@class = 'MOYcCv2eIJ _1_bHOFDacR']")).click();
        logger.info("Open all specifications");
        calculateOSinOnComparisonPage();
        driver.findElement(By.xpath("//div[@class = '_2bm8juabMn']")).click();
        logger.info("Open diff specifications");
        isTypeMobileEmpty();
        logger.info(driver.getTitle());

    }


    private static void showMoreWait() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = '_8v6CFFrbuZ' ]//button[contains(text(),'Показать ещё')]"))).click();
        logger.info("Button 'see else' available");
    }

    private static void waitComparisonButton() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href = '/my/compare-lists']"))).sendKeys(Keys.ENTER);
    }

    private static void addProductToComparison() {
        if (driver.findElement(By.xpath("//div[@class='nMEoEKZaF-']")).isDisplayed()){
            logger.info("Product add to comparing");
        }
    }
    private static void calculateOSinOnComparisonPage(){
        List listOfOS = driver.findElements(By.xpath("//*[text() = 'Версия ОС на начало продаж']"));
        logger.info("Count of OS - " + listOfOS.size());
    }
    private static void isTypeMobileEmpty(){
        List listOfTypeMobile = driver.findElements(By.xpath("//div[@class = '_3B3AAKx4qr']//div[text() = 'смартфон']"));
        if (listOfTypeMobile.size()>0){
            logger.info("Type Of Mobile Available");
        }else
            logger.info("Type Of Mobile NOT AvailAble");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("driver shutDown");
    }
}
