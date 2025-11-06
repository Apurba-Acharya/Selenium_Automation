package ex27_testNG.TNG17_listeners_reLearnVVI;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TNG18A_listeners implements ITestListener {

    /* listeners: It is an interface that is listen to the even set of performed by the testNG.
      -> If we want to perform any operations at perticulers events in testNG then we can use the listeners.
      -> Following listeners are available in testNG: - IAnnotationTransformer, IAnnotationTransformer2, IHookable,
         IInvokedMethodListener, IMethodInterceptor, IReporter, ISuiteListener, ITestListener etc.
     Difference between listeners and annotations:
        1. annotations are limited, and they are very clear as functionality wise.
           listeners are not limited that will provide you different funtionalites
        2. Listeners will listen the different type of event and annotations are limited */

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("onTestSkipped");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("onTestFailedWithTimeout");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish");
    }
}
