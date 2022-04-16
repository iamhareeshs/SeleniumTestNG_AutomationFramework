# Selenium TestNG Automation Framework

This automation framework is for parabank parasoft (https://parabank.parasoft.com/) test application.
Pre-requisite to execute test framework is parabank application should be up and running.

**Framework details:**
It is a maven project written in Selenium with Java following hydrid automation framework development approach. Here is the explanation of various aspects of project directory,

1.	pom.xml - It is an XML file that contains configuration details used by Maven to build the project. 
2.	testng.xml- This Xml file is in target/suites folder. It is used to invoke TestNG, suite name is specified along with testname. It will execute class files mentioned in class tags. 
3.	properties: Object repository and common data are stored as properties, It is stored as key-value pair. This directory is in main/resources
4.  tesdata : Testdata is provided from excelsheet testdata_sheet.xlsx. This is in main/resources/testdata.
    Tesdata for each test can be stored in the same excel as a new sheet. 

**Test Covered:** Following test classes cover below features of the application:
Registration : Validate new user registration in parabank application 

**To execute test from intelliJ / Eclipse :**
1. From commandline
   mvn clean install  test -Durl="https://parabank.parasoft.com/" -DbrowserName="CHROME"  -Dsu
   iteXmlFile="testng.xml" (This test running in chrome browser for environment "https://parabank.parasoft.com/")

Notes:
1. Browser and app url are supplied from environment variables.
   URL=https://parabank.parasoft.com/;BROWSER_TYPE=CHROME

