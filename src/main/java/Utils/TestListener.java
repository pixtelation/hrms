package Utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Base.Launch;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.getReportInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("✅ Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        // Log failure reason
        test.get().fail(result.getThrowable());

        // Capture screenshot
        try {
            WebDriver driver = Launch.getDriver();

            if (driver != null) {
                String screenshotPath = captureScreenshot(
                        driver,
                        result.getMethod().getMethodName()
                );
                test.get().addScreenCaptureFromPath(screenshotPath);
            } else {
                test.get().warning("⚠ Driver was null, screenshot not captured");
            }

        } catch (Exception e) {
            test.get().warning("⚠ Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("⏭ Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // -------------------------------------------------
    // 📸 Screenshot utility
    // -------------------------------------------------
    private String captureScreenshot(WebDriver driver, String testName)
            throws IOException {

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String screenshotDir =
                System.getProperty("user.dir") + "/test-output/screenshots/";

        File dir = new File(screenshotDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String screenshotPath =
                screenshotDir + testName + ".png";

        File dest = new File(screenshotPath);
        src.renameTo(dest);

        return screenshotPath;
    }
}
