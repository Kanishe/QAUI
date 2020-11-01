package page;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    public LoginPage(WebDriver driver) {
        super(driver);
    }

/*locator for login*/
    @FindBy (xpath = "//div[@class = 'new-input-placeholder' and contains (text(),'Электронная почта ')]")
    private  WebElement loginField;

//locator for password adminadmin (advise)//
    @FindBy(xpath = "//div[@class = 'new-input-placeholder' and contains (text(),'Введите пароль ')]")
    private WebElement passField;


    @FindBy(xpath = "//button[@data-modal-id='new-log-reg']")
    private WebElement authButt;



    public LoginPage open(){
        driver.get(cfg.url());
        return this;
    }
    public LoginPage loginPage (String login){
        driver.findElement(By.xpath(String.valueOf(authButt))).click();
        return this;
    }
}
