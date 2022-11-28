package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

import java.util.*;

import static org.openqa.selenium.remote.CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR;

public class WebDriverUtils {
    //private static WebDriver driver;

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private static List<WebDriver> storedDrivers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                storedDrivers.stream().forEach(WebDriver::quit);
            }
        });
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void addDriver(WebDriver driver) {
        storedDrivers.add(driver);
        drivers.set(driver);
    }

    protected static void removeDriver() {
        storedDrivers.remove(drivers.get());
        drivers.remove();
    }

    public static void webDriverCreation(String usedDriver) {
        if (getDriver() == null) {
            if (usedDriver.equals("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setAcceptInsecureCerts(true);
                chromeOptions.setCapability(UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

                WebDriverManager.chromedriver().setup();
                //drivers.set(new ChromeDriver(chromeOptions));
                addDriver(new ChromeDriver());
                getDriver().manage().window().maximize();

            } else if (usedDriver.equals("firefox")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setAcceptInsecureCerts(true);
                firefoxOptions.setCapability(UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver(firefoxOptions);
                addDriver(new FirefoxDriver());
                getDriver().manage().window().maximize();

            }
        }
    }

    public static void webDriverTeardown() {
        if (getDriver() != null) {
            getDriver().close();
            getDriver().quit();
            removeDriver();
        }
    }
}
