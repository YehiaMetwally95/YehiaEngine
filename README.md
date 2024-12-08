# Overview
- Test Automation Engine for Websites, APIs and Mobile Apps (Native Android / Native IOS / Web App)
- Written in Java for Maven Projects that built over Selenium 4 and Appium 2 and Rest Assured
- Provide very Easy Interactions with Web Elements, Rest API Requests and Native Mobile Elements Without any need to Scroll Element till displayed into View
- Configured to Run Web Tests Locally / Headless and Remotely on Selenium Grid with Docker Containers
- Configured to Run Mobile Tests Locally and Remotely on BrowserStack & SauceLabs
- Configured to Run Tests In Parallel in Various Modes
- Auto-Generation of Allure Report after Every Test Run and Easily Opening it from .bat File
- Logging All Test Steps and Screenshots
- Provide Properties Files for All Configurations of Web App / Mobile App / API / Database / Parallelization

# Features
### Element Interactions
- WebElementActions Class for Different Interactions with Web Elements
- W3CTouchActions Class for Different Interactions with Mobile Elements "Android or IOS", Based on W3C Actions APIs for Swiping and other Gestures
- NativeAndroidActions for Different Interactions with Native Android Elements, Based on UIScrollable Class for Swiping Into Screen and Into Element Without using x,y Coordinates
- Simulating All Mobile Gestures like Tap / Long Tab /Zoom / DragAndDrop/ Swipe, with only one command while Auto Scrolling to the Target Element into view (Scroll into Screen or into Swiped Element)
- Synchronizing All Elements Identifications and All Actions taken on elements inside Fluent Wait with lambda expression, thus waiting till action is taken not just till finding the element

### Browser Interactions
- WindowManager Class for Different Interactions with Browser Windows

### Driver Managers
- BrowserFactory Class for Setting different Browser Types, Local/Remote Execution, Browser Capabilities and Open/Close Browsers
- AppiumFactory Class for Setting different App Types (NativeAndroid /Native IOS /WebApp), Execution Type (Local / SauceLabs / BrowserStack) ,Cloud Server Configurations, Different Capabilities for (Platform /Device /App) and Open/Close Application

### Logging
- Using log4j2 Logging Framework for Logging Every Single Step Run on Test Script
- Logging (Info Steps & Warning Steps & Error Steps) on Console with Colors, for Easier and Quicker Debugging
- Uploading Log Files into Project Folder for Every Method run (Either Test Methods or Configuration Methods)
- Logging Summery for all Soft Assertion Failures for Every Test
- Taking Screenshots for All Failed Tests , Succeeded Test and Soft Assertion Failures
- Uploading All Log Files , All Screenshots to Allure Report

### Reporting
- Create bat File "Open_Allure_Report.bat" to easily open Allure Report after Every Test Run
- Logging All Scenario Steps and Test Validations on Allure Report, in form of main steps and expanding every main step to check its child steps
- Reporting Test Result & Taking Screenshots for Failed Tests and Successful Tests
- Reporting Soft assertion failures and Taking Screenshots for them
- Reporting All API Requests and Responses Sent, with a Screenshot for each
- Defining Epics/Features/Stories
- Attach Log File to its related Method (Either Test Methods or Configuration Methods)

### Parallelization
- Provide All Parallel Modes "NONE, METHODS , TESTS , CLASSES" for Running Web Tests & Mobile Tests & API Tests
- Able to Configure Parallel Mode and No of Threads
- Parallelization Options of running test classes through "TestNG" by directly press on Run Button & through "Maven Surefire Plugin" by running tests from Command Prompt or from CI-CD Pipeline

### Configuration Files
- PropertiesFiles that hold all Configurations related to APIs, Databases, Web Apps, Waits Timeouts and Parallel Modes
- PropertiesFiles that hold all Mobile App Configurations as Execution Type / Cloud Server Configurations / App Type / Browser Type / Device, App and Platform Capabilities
- Configuration Execution of Web Tests / Mobile Tests Locally or Remotely over SauceLabs or Browser Stack or Docker
- DockerFiles that hold docker compose files for setting Selenium Grid Hub and Nodes and Setting mysql Database on Docker Containers
- Apps Folder that hold Mobile Apps .apk Files Used in Testing
- DbFiles that hold all .sql files of Databases used in Testing
- Screenshots that hold all Screenshots for Succeeded / Failed Scenarios and Soft Assertion Failures

### Data Managers
- ApisManager for handling interactions with APIs like "Send Post / Get / Delete Requests" , Get Values from API Responses and different validations on API Responses
- JDBCManager for handling interactions with Database like Retrieve Data Tables from DB and Insert new values on DB Tables
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
