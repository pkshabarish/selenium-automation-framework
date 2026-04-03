package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class Listener extends ExtentReportManager implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        initReport();
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String path = ScreenshotUtil.captureScreenshot(BaseClass.driver, result.getName());

        test.pass("Test Passed");

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path = ScreenshotUtil.captureScreenshot(BaseClass.driver, result.getName());

        test.fail("Test Failed: " + result.getThrowable());

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        flushReport(); // 🔥 VERY IMPORTANT
    }
}