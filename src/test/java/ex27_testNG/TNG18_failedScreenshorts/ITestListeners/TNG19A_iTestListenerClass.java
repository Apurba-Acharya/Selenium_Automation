package ex27_testNG.TNG18_failedScreenshorts.ITestListeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TNG19A_iTestListenerClass extends TNG19A_BaseTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName());
        captureScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+".jpg");
    }
}
