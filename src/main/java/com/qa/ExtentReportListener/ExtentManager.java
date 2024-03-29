package com.qa.ExtentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("extent-report.html");
        }
        return extent;
    }

    private static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        return extent;
    }
}

