package pages;

import com.basic.actions.PreDefinedActions;
import com.basic.utils.ObjectReader;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class RegistrationPage extends PreDefinedActions {

    public final Properties registrationProperties;

    public RegistrationPage() {
        registrationProperties = ObjectReader.getObjectRepository("Registration");
    }

    public void navigateToRegistrationPage() {
        PreDefinedActions.clickElement(registrationProperties.getProperty("register"));
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

    public WebElement getRegPageTitle(){
        return  getPageElement(registrationProperties.getProperty("registrationPageTitle"));
    }

    public WebElement getRegisterButton(){
        return  getPageElement(registrationProperties.getProperty("registerButton"));
    }

    public  WebElement getRegisterMessage(){
        return  getPageElement(registrationProperties.getProperty("welcomeMessage"));
    }

    public  WebElement getLogoutButton(){
        return  getPageElement(registrationProperties.getProperty("logoutButton"));
    }

    public String getRegistrationSuccessMessage(){
        return  getRegisterMessage().getText().replace("\n", "").trim();
    }

}
