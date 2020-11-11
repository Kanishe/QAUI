import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidTest {
    public static WebDriver driver;
    @BeforeEach
    public static void setUp () throws MalformedURLException  {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName("chrome");
            desiredCapabilities.setVersion("78.0");
            desiredCapabilities.setCapability("enableVNC",true);
            desiredCapabilities.setCapability("enableVideo",false);
            driver = new RemoteWebDriver(
                    new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities
            );

    }
    @AfterEach
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
