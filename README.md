# **Page Object model Test automation framework using Selenium with Java, TestNG, Maven, WebDriverManager with data driven approach** 

## **This is a sample project to demonstrate what is page object model framework and how it can used in selenium to automate any application. TestNG is used as test framework**

**(1) First we have to copy git repository on our local system and below command from command line:**

```
git clone https://github.com/kartikeya27/SeleniumFrameworkDemo.git
cd SeleniumFrameworkDemo
mvn clean compile test

```
**(2) Ncessary Libraries and Software:** 

```
(1) Install maven on MAC and add maven path into environment path inside ./bashrc_profile.
(2) Install jdk11 on mac and add path into environment path inside ./bashrc_profile.
(3) Type java --version and mvn --version.
(4) I used WebDriverManager.
(5) It is maven based porject so all necessary dependecnies will download it automatically once you import
    this project in any preferable IDE.

```
**(3) run test from different area:** 
```
* Once we copy this project on local system either we can run the test cases from command line 
  or from any IDE of your preference. In Eclipse IDE we can right click on textng.xml inside 
  /src/main/resources folder and run as a TestNG suites.
* We can also run from LoginTest.java file right click on it and run as a TestNG suites.


```
### **Structure about this framework:**
```
1. Testbase package is the place where we can put all commom functionalty of the testcase as well as how to 
   launch the browser.

2. config package with global variable for example testing url.

3. page package where all id, name or xpath locator with common method dscribe here using page factory.

4. testdata package holds a test data.

5. resources package have xlsx file logs and data common utility.

6. test package where we define our testcases.

7. ExtentReportListener package for extent report functionality.

8. FailedTestsScreenshots will generate automatiacally if any of the test cases fail.
 
``` 

### **Test Structure:**
```
Tests are structured using TestNG annotations (@Test, @BeforeMethod, @AfterMethod). Each test method represents a scenario, such as searching on Google, Bing, etc. The Page Object Model (POM) design pattern is followed to represent web pages.
``` 

### **Explanation::**
```
1. Test Structure: We use TestNG for structuring and executing tests. Each test method represents a scenario, such as searching on Google, Bing, etc.

2. Page Object Model: Each web page is represented by a corresponding Page Object. This helps in better organization of code, improves readability, and reduces duplication.

3. Base Test Class: Contains setup and teardown methods to initialize WebDriver and perform cleanup after each test execution.

4. Assertions: We use TestNG's soft assertions to collect all failures without halting the test execution.
``` 

### **Considerations:**
```
1. Design Patterns: The Page Object Model (POM) is an industry-standard design pattern for Selenium automation, providing a clean separation of concerns between test code and page-specific code.

2. Enterprise-level Support: This framework can be extended to support enterprise-level applications by integrating with CI/CD pipelines, logging, reporting, and parallel test execution.

3. Minimization of Anti-patterns: By following POM, we avoid anti-patterns such as code duplication, tightly coupled code, and mixing of concerns.

4. Extensibility: Adding support for new search engines or modifying existing tests is straightforward. Simply create new Page Object classes for the respective search engines and update test methods accordingly.

By adhering to these principles and patterns, the test framework ensures scalability, maintainability, and robustness, making it suitable for enterprise-level applications.
``` 

``` 
### **Project Structure diagram of this framework:** 

├── README.md
├── Screenshots
│   ├── searchTest.png
│   └── search_failure_google.com.png
├── extent-report.html
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── qa
│   │   │           ├── ExtentReportListener
│   │   │           │   └── ExtentManager.java
│   │   │           ├── base
│   │   │           │   └── TestBase.java
│   │   │           ├── pages
│   │   │           │   ├── HomePage.java
│   │   │           │   └── SearchResultPage.java
│   │   │           ├── testdata
│   │   │           │   └── testdata.xlsx
│   │   │           └── util
│   │   │               ├── ExcelUtil.java
│   │   │               ├── ExtentManager.java
│   │   │               ├── ScreenshotUtil.java
│   │   │               └── TestListener.java
│   │   └── resources
│   │       ├── config.properties
│   │       ├── log4j.properties
│   │       ├── testdata.xlsx
│   │       └── testng.xml
│   └── test
│       ├── java
│       │   └── com
│       │       └── qa
│       │           └── tests
│       │               └── SearchEngineTest.java
│       └── resources
├── target
│   ├── classes
│   │   ├── META-INF
│   │   │   ├── MANIFEST.MF
│   │   │   └── maven
│   │   │       └── com.clover
│   │   │           └── SeleniumFrameworkDemo
│   │   │               ├── pom.properties
│   │   │               └── pom.xml
│   │   ├── com
│   │   │   └── qa
│   │   │       ├── ExtentReportListener
│   │   │       │   └── ExtentManager.class
│   │   │       ├── base
│   │   │       │   └── TestBase.class
│   │   │       ├── pages
│   │   │       │   ├── HomePage.class
│   │   │       │   └── SearchResultPage.class
│   │   │       ├── testdata
│   │   │       │   └── testdata.xlsx
│   │   │       └── util
│   │   │           ├── ExcelUtil.class
│   │   │           ├── ExtentManager.class
│   │   │           ├── ScreenshotUtil.class
│   │   │           └── TestListener.class
│   │   ├── config.properties
│   │   ├── log4j.properties
│   │   ├── testdata.xlsx
│   │   └── testng.xml
│   ├── generated-sources
│   │   └── annotations
│   ├── generated-test-sources
│   │   └── test-annotations
│   ├── maven-status
│   │   └── maven-compiler-plugin
│   │       ├── compile
│   │       │   └── default-compile
│   │       │       ├── createdFiles.lst
│   │       │       └── inputFiles.lst
│   │       └── testCompile
│   │           └── default-testCompile
│   │               ├── createdFiles.lst
│   │               └── inputFiles.lst
│   ├── surefire-reports
│   │   ├── TEST-com.qa.tests.SearchEngineTest.xml
│   │   ├── bullet_point.png
│   │   ├── collapseall.gif
│   │   ├── com.qa.tests.SearchEngineTest
│   │   │   ├── Command line test.html
│   │   │   └── Command line test.xml
│   │   ├── com.qa.tests.SearchEngineTest.txt
│   │   ├── emailable-report.html
│   │   ├── failed.png
│   │   ├── index.html
│   │   ├── jquery.min.js
│   │   ├── junitreports
│   │   │   └── TEST-com.qa.tests.SearchEngineTest.xml
│   │   ├── navigator-bullet.png
│   │   ├── old
│   │   │   ├── com.qa.tests.SearchEngineTest
│   │   │   │   ├── Command line test.properties
│   │   │   │   ├── classes.html
│   │   │   │   ├── groups.html
│   │   │   │   ├── index.html
│   │   │   │   ├── main.html
│   │   │   │   ├── methods-alphabetical.html
│   │   │   │   ├── methods-not-run.html
│   │   │   │   ├── methods.html
│   │   │   │   ├── reporter-output.html
│   │   │   │   ├── testng.xml.html
│   │   │   │   └── toc.html
│   │   │   └── index.html
│   │   ├── passed.png
│   │   ├── skipped.png
│   │   ├── testng-reports.css
│   │   ├── testng-reports.js
│   │   ├── testng-reports1.css
│   │   ├── testng-reports2.js
│   │   ├── testng-results.xml
│   │   └── testng.css
│   └── test-classes
│       └── com
│           └── qa
│               └── tests
│                   └── SearchEngineTest.class
└── test-output
    ├── Default suite
    │   ├── Default test.html
    │   ├── Default test.xml
    │   └── testng-failed.xml
    ├── ExtentReport.html
    ├── Test Suite
    │   ├── Search Engine Tests.html
    │   ├── Search Engine Tests.xml
    │   └── testng-failed.xml
    ├── bullet_point.png
    ├── collapseall.gif
    ├── emailable-report.html
    ├── failed.png
    ├── index.html
    ├── jquery.min.js
    ├── junitreports
    │   └── TEST-com.qa.tests.SearchEngineTest.xml
    ├── navigator-bullet.png
    ├── old
    │   ├── Default suite
    │   │   ├── Default test.properties
    │   │   ├── classes.html
    │   │   ├── groups.html
    │   │   ├── index.html
    │   │   ├── main.html
    │   │   ├── methods-alphabetical.html
    │   │   ├── methods-not-run.html
    │   │   ├── methods.html
    │   │   ├── reporter-output.html
    │   │   ├── testng.xml.html
    │   │   └── toc.html
    │   ├── Test Suite
    │   │   ├── Search Engine Tests.properties
    │   │   ├── classes.html
    │   │   ├── groups.html
    │   │   ├── index.html
    │   │   ├── main.html
    │   │   ├── methods-alphabetical.html
    │   │   ├── methods-not-run.html
    │   │   ├── methods.html
    │   │   ├── reporter-output.html
    │   │   ├── testng.xml.html
    │   │   └── toc.html
    │   └── index.html
    ├── passed.png
    ├── skipped.png
    ├── testng-failed.xml
    ├── testng-reports.css
    ├── testng-reports.js
    ├── testng-reports1.css
    ├── testng-reports2.js
    ├── testng-results.xml
    └── testng.css
  

