package cases;

import org.junit.jupiter.api.Test;
import page.LoginPage;
import utils.BaseHooks;

public class OtusLoginAction extends BaseHooks {
    @Test
    public void testBioPageObject(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
    }








//    @BeforeEach
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions op = new ChromeOptions();
//        driver = new ChromeDriver(op);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        logger.info("Driver is setup");
//    }
//
//    @Test
//    public void openPage(){
//        driver.get(cfg.url());
//        logger.info("Otus main page is open - " + driver.getCurrentUrl());
//
//    }

//    @AfterEach
//    public void setDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//       // logger.info("Driver shutDown");
//    }

}
