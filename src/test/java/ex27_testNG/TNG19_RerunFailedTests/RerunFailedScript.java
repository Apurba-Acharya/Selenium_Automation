package ex27_testNG.TNG19_RerunFailedTests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunFailedScript implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxCount = 3;

    @Override
    public boolean retry (ITestResult result){
        if(retryCount < maxCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
