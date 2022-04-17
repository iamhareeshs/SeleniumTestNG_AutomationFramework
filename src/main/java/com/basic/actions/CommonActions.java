package com.basic.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.RegistrationPage;

public class CommonActions {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonActions.class);
    public void logout(){
        try {
            RegistrationPage registrationPage = new RegistrationPage();
            PreDefinedActions.clickElement(registrationPage.registrationProperties.getProperty("logoutButton"));
        }catch (Exception e){
            LOGGER.error("Application Logout failed ! " + e);
        }
    }
}
