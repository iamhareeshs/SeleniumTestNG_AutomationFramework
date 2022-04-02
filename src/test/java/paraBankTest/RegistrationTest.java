package paraBankTest;

import com.basic.data.RegistrationData;
import com.basic.utils.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import testEnvironments.BaseUITest;

public class RegistrationTest extends BaseUITest {
    RegistrationPage registrationPage = null;

    @BeforeTest(alwaysRun = true)
    private void beforeClass() {
        registrationPage = new RegistrationPage();
    }

    @Test(priority = 1, dataProvider = "getData")
    private void userRegistrationTest(RegistrationData registrationTestData) {

        registrationPage.navigateToRegistrationPage();
        Assert.assertEquals(registrationPage.getRegPageTitle().getText(), commonData.getProperty("registrationPageTitle"), "Registration page is not loaded !");
        registrationPage.getFirstName().sendKeys(registrationTestData.getFirstName());
        registrationPage.getLastName().sendKeys(registrationTestData.getLastName());
        registrationPage.getAddress().sendKeys(registrationTestData.getAddress());
        registrationPage.getCity().sendKeys(registrationTestData.getCity());
        registrationPage.getState().sendKeys(registrationTestData.getState());
        registrationPage.getZipcode().sendKeys(registrationTestData.getZipcode());
        registrationPage.getPhone().sendKeys(registrationTestData.getPhone());
        registrationPage.getSSN().sendKeys(registrationTestData.getSSN());
        registrationPage.getUserName().sendKeys(registrationTestData.getUserName());
        registrationPage.getPassword().sendKeys(registrationTestData.getPassword());
        registrationPage.getConfirmPassword().sendKeys(registrationTestData.getPassword());

    }

    @DataProvider
    public Object[][] getData() {
        return TestDataReader.fetchTestData(TestDataReader.fetchDataFromExcelSheet("Registration"), RegistrationData.class);
    }
}
