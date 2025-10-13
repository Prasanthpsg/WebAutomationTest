package com.seersolutions.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;


import java.io.File;
public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((com.seersolutions.basetest.BaseTest) currentClass).driver;

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dest = "screenshots/" + result.getName() + ".png";
            FileUtils.copyFile(src, new File(dest));
            System.out.println("Screenshot saved: " + dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
