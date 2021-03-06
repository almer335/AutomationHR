package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.automation.webdriver.ExtendedWebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;


public class BaseHTMLReporter implements ITestListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseHTMLReporter.class);

    private static ExtentReports extent = ExtentManager.createInstance();

    private static ExtentTest test;

    private ExtendedWebDriver extendedWebDriver;

    @Override
    public synchronized void onTestStart(ITestResult result) {
        LOGGER.info((result.getMethod().getMethodName() + " started!"));
        extendedWebDriver = (ExtendedWebDriver) result.getAttribute("driver");
        test = extent.createTest(result.getTestClass().getRealClass().getSimpleName() + " :: " + result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.assignCategory(result.getTestClass().getRealClass().getSimpleName());
    }

    @Override
    public synchronized void onStart(ITestContext context) {
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        LOGGER.info((result.getMethod().getMethodName() + " passed!"));
        test.log(Status.PASS, MarkupHelper.createLabel("Test Case PASSED", ExtentColor.GREEN));
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        LOGGER.error(methodName + " failed!");
        test.log(Status.FAIL, MarkupHelper.createLabel("Test case FAILED due to below issues:", ExtentColor.RED));
        test.fail(result.getThrowable());

        if (extendedWebDriver != null) {
            WebDriver augmentedDriver = extendedWebDriver.getAugmentedDriver();
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            File destination = new File("target/Extent/" + methodName + ".PNG");
            try {
                FileUtils.copyFile(source, destination);
                test.addScreenCaptureFromPath(destination.getPath()).fail(result.getThrowable());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        LOGGER.info((result.getMethod().getMethodName() + " skipped!"));
        test.log(Status.SKIP, MarkupHelper.createLabel("Test Case SKIPPED", ExtentColor.ORANGE));
        test.skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LOGGER.info(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }

}
