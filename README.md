# Overveiw
- Automation Engine for Websites , APIs and Mobile Apps
- Written in Java for Maven Projects built on Selenium or Appium or Rest Assured

# Features
### Element Interactions
- WebElementActions Class for Different Interactions with Web Elements
- W3CTouchActions Class for Different Interactions with Mobile Elements "Android or IOS", Based on W3C Actions APIs for Swiping and other Gestures
- NativeAndroidActions for Different Interactions with Native Android Elements, Based on UIScrollable Class for Swiping
- Synchronizing the Elements identification and Actions on elements inside Fluent Wait with lambda expression, thus waiting till action is taken not just till finding the element

### Browser Interactions
- WindowManager Class for Different Interactions with Browser Windows

### Driver Managers
- BrowserFactory Class for Setting different Browser Types, Local/Remote Execution, Browser Capabilities and Open/Close Browsers
- AppiumFactory Class for Setting different App Types (NativeAndroid /Native IOS /WebApp) , different Capabilities for (Platform /Device /App) and Open/Close Application

### Logging
- Using log4j2 Logging Framework for Logging Every Single Step Run on Test Script
- Logging (Info Steps & Warning Steps & Error Steps) on Console with Colors, for Easier and Quicker Debugging
- Create Log Files into Project Folder for Every Method run (Either Test Methods or Configuration Methods)
- Logging Summery for all Soft Assertion Failures for Every Test
- Take Screenshots for All Failed Tests , Succeeded Test and Soft Assertion Failures
- Uploading All Log Files , All Screenshots to Allure Report

### Reporting
- Logging All Scenario Steps and Test Validations on Allure Report, in form of main steps and expanding every main step to check its child steps
- Reporting Test Result & Taking Screenshots for Failed Tests and Successful Tests
- Reporting Soft assertion failures and Taking Screenshots for them
- Reporting All API Requests and Responses Sent, with a Screenshot for each
- Defining Epics/Features/Stories
- Attach Log File to its related Method (Either Test Methods or Configuration Methods)
- "Open_Allure_Report.bat" file to easily open allure report every test run 

### Parallelization
- Provide All Parallel Modes "NONE, METHODS , TESTS , CLASSES" for Running Tests
- Able to Configure Parallel Mode and No of Threads
- Parallelization Options of running test classes through "TestNG" by directly press on Run Button & through "Maven Surefire Plugin" by running tests from Command Prompt or from CI-CD Pipeline

### Configuration Files
- PropertiesFiles that hold all configurations related to APIs, DataBases, Mobile Apps , Web Apps, Waits and Parallel Modes
- DockerFiles that hold docker compose files for setting selenium grid and setting mysql database on docker containers
- Apps Folder that hold mobile apps files used in Testing
- DbFiles that hold all .sql files of Databases used in Testing
- Screenshots that hold all screenshots for succeeded / failed and soft assertion failures

### Data Managers
- ApisManager for handling interactions with APIs like "Send Post / Get / Delete Requests" , Get Values from API Responses and different validations on API Responses
- JdbcManager for handling interactions with Database like Retrieve Data Tables from DB and Insert new values on DB Tables
- JsonManager for handling interactions with Json like Create/Read JsonFiles, Read/Set Test Data from Json Files by JsonPath
- CookiesManager for handling interactions with Browser Cookies like Build Cookies, Add or Get or Delete Cookies
- PropertiesManager for handling interactions with Configuration Files like Load Properties Files and Get configured values from Properties Files
- SessionManager for handling interactions with Browser Session like Getting Current Session Cookies, Storing Cookies, Applying Cookies to Current Session to Bypass Login

### Assertions
- CustomAssert for All Hard Assertions of TestNG Assert Class, in addition with Logging
- CustomSoftAssert for All Soft Assertions of TestNG SoftAssert Class, in addition with Logging

### Listeners
- Method Listeners for Perform actions before and after every method run like log create log files for each method, take screenshots for failed/succeeded methods
- Suite Listeners for Perform actions before and after suite run like Load Properties files and Clear any rubbish data before suite run
- Allure Listeners for Upload Log Files related to Configuration Methods to Allure Report

### Utilities
- DeleteDirectoryFiles for Delete all rubbish files before suite run like Screenshots, Log and Allure files
- RandomDataGenerator for Generating Test Data Dynamically on Run time using TimeStamp for unique Data and DataFaker for descriptive data
