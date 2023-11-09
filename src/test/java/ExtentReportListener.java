import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Page;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;


public class ExtentReportListener implements ITestListener {

    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println("Test Suite is ending!");
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println("\uD83D\uDE42 " + result.getMethod().getMethodName() + " passed!");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println("\uD83D\uDC1E " + result.getMethod().getMethodName() + " failed!");
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println("\uD83D\uDD18 " + result.getMethod().getMethodName() + " skipped!");
    }
}
