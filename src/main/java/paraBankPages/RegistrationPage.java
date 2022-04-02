package paraBankPages;

import com.basic.actions.PreDefinedActions;
import com.basic.data.RegistrationData;
import com.basic.utils.ObjectReader;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class RegistrationPage extends PreDefinedActions {

    PreDefinedActions preDefinedActions = new PreDefinedActions();
    private final Properties registrationProperties;
    RegistrationData registrationData = new RegistrationData();

    public RegistrationPage() {
        registrationProperties = ObjectReader.getObjectRepository("Registration");
    }

    public void navigateToRegistrationPage() {
        preDefinedActions.clickElement(registrationProperties.getProperty("register"));
    }

    public WebElement getFirstName() {
        return getPageElement(registrationProperties.getProperty("firstName"));
    }

    public WebElement getLastName() {
        return getPageElement(registrationProperties.getProperty("lastName"));
    }

    public WebElement getAddress() {
        return getPageElement(registrationProperties.getProperty("address"));
    }

    public WebElement getCity() {
        return getPageElement(registrationProperties.getProperty("city"));
    }

    public WebElement getZipcode() {
        return getPageElement(registrationProperties.getProperty("zipcode"));
    }

    public WebElement getPhone() {
        return getPageElement(registrationProperties.getProperty("phone"));
    }
    public WebElement getSSN() {
        return getPageElement(registrationProperties.getProperty("ssn"));
    }
    public WebElement getUserName() {
        return getPageElement(registrationProperties.getProperty("userName"));
    }
    public WebElement getPassword() {
        return getPageElement(registrationProperties.getProperty("password"));
    }
    public WebElement getConfirmPassword() {
        return getPageElement(registrationProperties.getProperty("confirmPassword"));
    }
    public WebElement getState() {
        return getPageElement(registrationProperties.getProperty("state"));
    }


}
