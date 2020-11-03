package cases;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.MainPage;
import utils.BaseHooks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OtusLoginAction extends BaseHooks {

    private static String myFirstName = "myFirstName";
    private static String myLastName = "myLastName";
    private static String myFirstNameLatin = "myFirstNameLatin";
    private static String myLastNameLatin = "myLastNameLatin";
    private static String myBlogName = "myBlogName";

    @Test
    public void testBioPageObject(){
        MainPage mainPage = new MainPage();
        mainPage.open()
                .authOnMainPage()
                .loginInAccount("a.kanishevskiy@gmail.com","qadminadmin")
                .entry()
                .openPP()
                .names(myFirstName, myLastName, myFirstNameLatin, myLastNameLatin, myBlogName)
                .birthdate("09.11.1992")
                .addContacts("AD", "AD")
                .save();

        driver.manage().deleteAllCookies();
        logger.info("restart browser");

        mainPage = new MainPage();
        List<String> personalInfo;
        personalInfo = mainPage
                .open()
                .authOnMainPage()
                .loginInAccount("a.kanishevskiy@gmail.com","qadminadmin")
                .entry()
                .openPP()
                .getPersonalInfo();

        Assertions.assertTrue(personalInfo.contains(myFirstName),"myFirstName");
        Assertions.assertTrue(personalInfo.contains(myLastName),"myLastName");
        Assertions.assertTrue(personalInfo.contains(myFirstNameLatin),"myFirstNameLatin");
        Assertions.assertTrue(personalInfo.contains(myLastNameLatin),"myLastNameLatin");
        Assertions.assertTrue(personalInfo.contains(myBlogName),"myBlogName");
    }
}

