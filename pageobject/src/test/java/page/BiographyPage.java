package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BiographyPage extends AbstractPage{
    public BiographyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'header2-menu__item-wrapper header2-menu__item-wrapper__username']")
    private WebElement accountName;

    @FindBy(xpath = "//div[@class = 'header2-menu__dropdown-text']")
    private WebElement linkToBio;
}
