package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseHooks;

public class AuthPage extends BaseHooks {
    @FindBy(xpath = "//form[@action = '/login/']//input[@placeholder = 'Электронная почта']")
    public static WebElement maill;
    @FindBy(xpath = "//form[@action = '/login/']//input[@placeholder = 'Введите пароль']")
    public static WebElement password;
    @FindBy(xpath = "//form[@action = '/login/']//button[contains (@type, 'submit')]")
    public static WebElement submit;

    public AuthPage loginInAccount( String Email,String Password){
        PageFactory.initElements(driver, AuthPage.class);
        maill.sendKeys(Email);
        password.sendKeys(Password);
        password.sendKeys(Keys.ENTER);
        logger.info("Enter in account");
        return new AuthPage();
    }
    public BiographyPage entry (){
        PageFactory.initElements(driver, AuthPage.class);
        submit.click();
        return new BiographyPage();
    }
}
