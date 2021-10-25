package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNGRetryLogic implements IRetryAnalyzer {
    private int counter = 0;
    private int retries = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < retries){
            counter++;
            return true;
        }
        return false;
    }
}
