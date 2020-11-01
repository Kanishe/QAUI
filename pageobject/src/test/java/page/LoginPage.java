package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


/*locator for login*/
    @FindBy (xpath = "//div[@class = 'new-input-placeholder' and contains (text(),'Электронная почта ')]")
    private  WebElement loginField;

//locator for password adminadmin (advise)//
    @FindBy(xpath = "//div[@class = 'new-input-placeholder' and contains (text(),'Введите пароль ')]")
    private WebElement passField;

    public LoginPage loginPageEntry (String login,String pass ){
        return null;
    }
}
