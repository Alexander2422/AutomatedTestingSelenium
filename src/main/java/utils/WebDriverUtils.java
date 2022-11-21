package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.openqa.selenium.remote.CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR;

public class WebDriverUtils {
    public static WebDriver driver;

    public static void webDriverCreation(String usedDriver) {
        if (usedDriver.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.setCapability(UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        } else if (usedDriver.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setAcceptInsecureCerts(true);
            firefoxOptions.setCapability(UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().window().maximize();
        }
    }

    public static void webDriverTeardown() {
        //driver.close();
        driver.quit();
    }
}
