package com.qa.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String screenshotPath = null;
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            screenshotPath = "./Screenshots/" + screenshotName + ".png";
            FileUtils.copyFile(source, new File(screenshotPath));
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
            // Log the exception or rethrow it if needed
        }
        return screenshotPath;
    }
}
