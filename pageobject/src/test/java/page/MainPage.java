package page;

import cases.OtusLoginAction;
import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseHooks;

public class MainPage extends BaseHooks{
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @FindBy(xpath = "//button[@data-modal-id = 'new-log-reg']")
    private static WebElement authButton;

    public MainPage open (){
        driver.get(cfg.url());
        logger.info("Open OTUS main page - " + cfg.url());
        return this;
    }

//
//


    public AuthPage authOnMainPage(){
//initialization page factory for use @FindBy
        PageFactory.initElements(driver, MainPage.class);

        authButton.click();
        logger.info("Auth page OTUS is open" + authButton);
        return new AuthPage();
    }
}
