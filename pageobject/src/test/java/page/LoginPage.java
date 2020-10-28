package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


/*locator for login*/
    @FindBy (xpath = "//div[@class = 'new-input-placeholder' and contains (text(),'Электронная почта ')]")
    private  WebDriver loginField;
//adminadmin
/*locator for password*/
    @FindBy(xpath = "//div[@class = 'new-input-placeholder' and contains (text(),'Введите пароль ')]")
    private WebDriver passField;
}
