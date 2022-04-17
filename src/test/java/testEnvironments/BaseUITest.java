package testEnvironments;

import com.basic.driver.DriverFactory;
import com.basic.utils.ObjectReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class BaseUITest extends DriverFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseUITest.class);
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
