package paraBankTest;

import com.basic.actions.CommonActions;
import com.basic.actions.PreDefinedActions;
import com.basic.allure.AllureListener;
import com.basic.data.RegistrationData;
import com.basic.utils.TestDataReader;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import testEnvironments.BaseUITest;
import java.io.IOException;

public class RegistrationTest extends BaseUITest {
    RegistrationPage regPage = null;
    CommonActions commonActions = new CommonActions();

    @BeforeTest(alwaysRun = true)
    private void beforeClass() throws IOException {
        regPage = new RegistrationPage();
    }

    @Test(priority = 1, dataProvider = "getRegTestData")
    private void userRegistrationTest(RegistrationData registrationTestData) throws InterruptedException {
            String userName = PreDefinedActions.getRandomString(7);
            String expectedRegMessage = commonData.getProperty("registerSuccessMessage").replace("%name", userName);
            regPage.navigateToRegistrationPage();
            Assert.assertEquals(regPage.getRegPageTitle().getText(), commonData.getProperty("registrationPageTitle"), "Registration page is not loaded !");
            regPage.getFirstName().sendKeys(registrationTestData.getFirstName());
            regPage.getLastName().sendKeys(registrationTestData.getLastName());
            regPage.getAddress().sendKeys(registrationTestData.getAddress());
            regPage.getCity().sendKeys(registrationTestData.getCity());
            regPage.getState().sendKeys(registrationTestData.getState());
            regPage.getZipcode().sendKeys(registrationTestData.getZipcode());
            regPage.getPhone().sendKeys(registrationTestData.getPhone());
            regPage.getSSN().sendKeys(registrationTestData.getSSN());
            regPage.getUserName().sendKeys(userName);
            regPage.getPassword().sendKeys(registrationTestData.getPassword());
            regPage.getConfirmPassword().sendKeys(registrationTestData.getPassword());
            regPage.getRegisterButton().click();
            Assert.assertEquals(regPage.getRegistrationSuccessMessage(), expectedRegMessage , "New user registration failed ! Register success message is not as expected.");
    }

    @AfterMethod
    private void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        commonActions.logout();
        if (testResult.getStatus() == ITestResult.FAILURE) {
            AllureListener.addScreenshotInAllureReport("Failure in registration page !");
        }
    }

    @DataProvider
    public Object[][] getRegTestData() {
        return TestDataReader.fetchTestData(TestDataReader.fetchDataFromExcelSheet("Registration"), RegistrationData.class);
    }
}
