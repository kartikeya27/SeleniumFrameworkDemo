package com.qa.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.qa.base.TestBase;

public class TestListener extends TestBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        ExtentTest test = ExtentManager.getInstance().createTest(result.getName());
        test.pass("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
        ExtentTest test = ExtentManager.getInstance().createTest(result.getName());
        test.fail("Test Failed: " + result.getName());
        if (screenshotPath != null) {
            test.addScreenCaptureFromPath(screenshotPath);
			System.out.println("Screenshot added to Extent report"); // Add debug statement
        }
        // Log the exception stack trace in the Extent report
        test.fail(result.getThrowable());
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
        ExtentTest test = ExtentManager.getInstance().createTest(result.getName());
        test.skip("Test Skipped: " + result.getName());
    }

    // Implement other methods of the interface as per your requirement
}
