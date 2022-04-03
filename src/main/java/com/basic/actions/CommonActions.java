package com.basic.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.RegistrationPage;

public class CommonActions {
    private static final Logger LOGGER = LogManager.getLogger(CommonActions.class);
    PreDefinedActions preDefinedActions = new PreDefinedActions();
    public void logout(){
        try {
            RegistrationPage registrationPage = new RegistrationPage();
            preDefinedActions.clickElement(registrationPage.registrationProperties.getProperty("logoutButton"));
        }catch (Exception e){
            LOGGER.error("Application Logout failed ! " + e);
        }
    }
}
