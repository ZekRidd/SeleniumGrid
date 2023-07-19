package manager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    DesiredCapabilities capabilities = new DesiredCapabilities();
    public WebDriver setUpChromeDriver(){

        capabilities.setPlatform(Platform.ANY);
        capabilities.setBrowserName("Chrome");
        capabilities.setVersion("114.0.5735.198");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(capabilities);

        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.144:4444"), chromeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        System.out.println("***** Setup Chrome Driver *****");

        return driver;
    }

    public WebDriver setUpFirefoxDriver(){
        capabilities.setPlatform(Platform.ANY);
        capabilities.setBrowserName("Firefox");
        capabilities.setVersion("115.0.2");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.merge(capabilities);

        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.144:4444"), firefoxOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        System.out.println("***** Setup Firefox Driver *****");

        return driver;
    }
}
