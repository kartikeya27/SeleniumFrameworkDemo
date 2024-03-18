package com.qa.tests;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.ExtentReportListener.ExtentManager;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.SearchResultPage;
import com.qa.util.ExcelUtil;
import com.qa.util.ScreenshotUtil;

@Listeners(com.qa.util.TestListener.class)
public class SearchEngineTest extends TestBase {
    HomePage homePage;
    SearchResultPage searchResultPage;
    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    public SearchEngineTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test(dataProvider = "searchData")

    public void searchTest(String searchEngine, String searchTerm) {
        test = extent.createTest("Search Test - " + searchEngine);
        homePage.enterSearchTerm(searchTerm);
        homePage.submitSearch();
        String firstResult = searchResultPage.getFirstResultTitle();
        try {
            Assert.assertTrue(firstResult.contains(searchTerm), "Search term not found in first result");
            test.log(Status.PASS, "Search Test passed for search term: " + searchTerm);
        } catch (AssertionError e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "search_failure_" + searchEngine);
            test.fail("Test Failed for search term: " + searchTerm, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            // Log the exception stack trace in the Extent report
            test.fail(e);
            throw e; // Rethrow the AssertionError to mark the test as failed in TestNG
        }
    }


    @DataProvider(name = "searchData")
    public Object[][] getSearchData() throws IOException {
        return ExcelUtil.getTestData(System.getProperty("user.dir") + "/src/main/resources/testdata.xlsx", "SearchData");
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
}
