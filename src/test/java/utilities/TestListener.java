package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;

import base.BaseClass;

public class TestListener extends BaseClass implements ITestListener {

    ExtentReports extent = ExtentManager.getReportInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        System.out.println("STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
        System.out.println("PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        // Screenshot
        String path = "screenshots/" + result.getName() + ".png";
        ScreenshotUtils.captureScreenshot(driver, result.getName());

        test.addScreenCaptureFromPath(path);

        System.out.println("FAILED: " + result.getName());
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}