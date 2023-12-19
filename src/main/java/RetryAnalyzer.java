import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static int max_retry_count = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < max_retry_count) {
            retryCount++;
            return true;
        }
        return false;
    }
}
