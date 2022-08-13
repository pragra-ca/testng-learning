import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("********STARTING TEST **********");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("******** HURRAY PASSED **********");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("********SORRY WE HAVE PROBELM **********");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("********OOPS WE ARE SKIPPED **********" + result.getName());
    }


    @Override
    public void onStart(ITestContext context) {
        System.out.println("********STARTING SUITE **********");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("********COMPLETE SUITE **********");
    }
}
