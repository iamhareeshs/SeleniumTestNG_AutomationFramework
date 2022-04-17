package testEnvironments;

import com.basic.driver.DriverFactory;
import com.basic.utils.ObjectReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class BaseUITest extends DriverFactory {

    protected SoftAssertions softAssertions ;
    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);
    public  final Properties commonData = ObjectReader.getObjectRepository("CommonData");

    @BeforeSuite(alwaysRun = true)
    public void frameworkSetup(){
        String browserType = System.getProperty("browserName") == null? "CHROME" : System.getProperty("browserName");
        String url = System.getProperty("url") == null? "https://parabank.parasoft.com/" : System.getProperty("url");
        setDriver(browserType, url);
        LOGGER.info( browserType+ " browser launched successfully!");
    }

    @AfterSuite(alwaysRun = true)
    public void terminateDriver(){
        if (driver != null)
            driver.close();
    }
}
