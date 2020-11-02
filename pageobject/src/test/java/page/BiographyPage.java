package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BaseHooks;

public class BiographyPage extends BaseHooks {


    @FindBy(xpath = "//div[@class = 'header2-menu__item-wrapper header2-menu__item-wrapper__username']")
    private WebElement accountName;

    @FindBy(xpath = "//div[@class = 'header2-menu__dropdown-text']")
    private WebElement linkToBio;
}
