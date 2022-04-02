package paraBank;

import basetest.environments.BaseUITest;
import com.basic.data.RegistrationData;
import com.basic.utils.TestDataReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import paraBankPages.RegistrationPage;

public class RegistrationTest extends BaseUITest {
    RegistrationPage registrationPage = null;

    @BeforeTest
    private void beforeClass() {
        registrationPage = new RegistrationPage();
    }

    @Test(priority = 1, dataProvider = "getData")
    private void usreRegistrationTest(RegistrationData registrationTestData) {
        registrationPage.navigateToRegistrationPage();
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
