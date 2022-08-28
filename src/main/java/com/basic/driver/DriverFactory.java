package com.basic.driver;

import com.basic.constants.CommonPaths;
import com.basic.constants.CommonVariables;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;


public class DriverFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverFactory.class);
    public static WebDriver driver;

    public static void setDriver(String browserType, String appURL) {
        switch (browserType.toUpperCase()) {
            case "CHROME":
                driver = initChromeDriver(appURL);
                break;
            case "FIREFOX":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                LOGGER.info("Browser : " + browserType + " is invalid, Launching chrome as Default browser.");
                driver = initChromeDriver(appURL);
        }
    }

    // Open chrome browser
    private static WebDriver initChromeDriver(String appURL) {
        LOGGER.info("Launching chrome browser !");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonVariables.IMPLICITWAIT));
        return driver;
    }

    // Open Firefox browser
    private static WebDriver initFirefoxDriver(String appURL) {
        LOGGER.info("Launching Firefox browser !");
        System.setProperty("webdriver.gecko.driver", CommonPaths.DRIVER_PATH + File.separator + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(appURL);
        return driver;
    }

}