package basetest.environments;

import com.basic.actions.PreDefinedActions;
import com.basic.driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseUITest extends DriverFactory {

    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);

    @BeforeSuite(alwaysRun = true)
    public void frameworkSetup(){
        String browserType = System.getenv("BROWSER_TYPE") == null? "CHROME" : System.getenv("BROWSER_TYPE");
        String url = System.getenv("URL") == null? "https://www.google.co.in/" : System.getenv("URL");
        setDriver(browserType, url);
        LOGGER.info( browserType+ " browser launched successfully!");
    }

    @AfterSuite
    public void terminateDriver(){
        if (driver != null)
            driver.close();
    }
}
