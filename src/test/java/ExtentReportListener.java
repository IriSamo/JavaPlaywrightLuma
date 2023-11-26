import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


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
        System.out.println("✔\uFE0F " + result.getMethod().getMethodName() + " passed!");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println("❌ " + result.getMethod().getMethodName() + " failed!");
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println("❔ " + result.getMethod().getMethodName() + " skipped!");
    }
}
