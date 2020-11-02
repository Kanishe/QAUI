package cases;

import org.junit.jupiter.api.Test;
import page.MainPage;
import utils.BaseHooks;

public class OtusLoginAction extends BaseHooks {
    @Test
    public void testBioPageObject(){
        MainPage mainPage = new MainPage();
        mainPage.authOnMainPage();
    }
}
