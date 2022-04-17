package com.basic.actions;

import com.basic.constants.CommonVariables;
import com.basic.driver.DriverFactory;
import com.google.common.base.Strings;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.InputMismatchException;

public class PreDefinedActions extends  DriverFactory{
    private static final Logger LOGGER = LoggerFactory.getLogger(PreDefinedActions.class);
    public static WebDriverWait wait = new WebDriverWait(DriverFactory.driver, Duration.ofSeconds(CommonVariables.IMPLICITWAIT));

    private static String getLocatorType(String locator) {
        String locatorType = null;
        if (!Strings.isNullOrEmpty(locator)) {
            locatorType = locator.split(":")[0].trim();
        } else {
            LOGGER.error("Locator is missing in properties file !");
        }
        return locatorType;
    }

    private static String getLocatorValue(String locator) {

        String locatorValue = null;
        if (!Strings.isNullOrEmpty(locator)) {
            locatorValue = locator.split(":")[1].trim();
        } else {
            LOGGER.error("Locator is missing in properties file !");
        }
        return locatorValue;
    }

    public static By getPageObject(String locator) {
        LOGGER.info("Starting method getPageObject");
        try {
            String locatorType = getLocatorType(locator);
            String locatorVal = getLocatorValue(locator);

            switch (locatorType.toUpperCase()) {
                // Find by id
                case "ID":
                    return By.id(locatorVal);
                // Find by xpath
                case "XPATH":
                    return By.xpath(locatorVal);
                // Find by Classname
                case "CLASSNAME":
                    return By.className(locatorVal);

                // Find by Name
                case "NAME":
                    return By.name(locatorVal);

                // Find by CSS
                case "CSS":
                    return By.cssSelector(locatorVal);

                // Find by Link
                case "LINK":
                    return By.linkText(locatorVal);

                // Find by PartialLink
                case "PARTIALLINK":
                    return By.partialLinkText(locatorVal);

                default:
                    throw new InputMismatchException("You can use : ID, XPATH, CLASSNAME, NAME, CSS, LINK, PARTIALLINK only ");
            }
        } catch (Exception e) {
            return null;
        }
    }

    public WebElement getPageElement(String locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getPageObject(locator)));
        return element;
    }

    public static void clickElement(String locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getPageObject(locator)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        } catch (Exception e) {
            LOGGER.info("Element click failed ! " + e);
        }
    }

    public static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

}
