import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static ExtentReports.ExtentTestManager.startTest;

public class SampleTest extends BaseClass {
    @Test(timeOut = 3000,priority = 2,groups = {"smoke"})
    public void runLoginAndLogout(Method method) throws InterruptedException {
        startTest(method.getName(), "Test A1.");
        Log.info("A1");
        Thread.sleep(2000);
       // StandaloneTest.login();
        //StandaloneTest.logout();
    }

    @Test(priority = 0,groups = {"sanity"})
    public void runLoginAndLogout1(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");
        Log.info("A2");

        //StandaloneTest.login1();
        //StandaloneTest.logout();
    }
    @Test(expectedExceptions = {ArithmeticException.class})
    public void testAddition(Method method) {
        startTest(method.getName(), "Test AA.");
        int result = 2 + 3;
        Log.info("This test will fail");

        int a = 1/0;
        Log.info("This test will fail");
        Assert.assertEquals(result, 5);
    }

    @Test(priority = 1)
    public void runLoginAndLogout3(Method method) {
        startTest(method.getName(), "Test A3.");
        Log.info("A3");
        Reporter.log("simply logginf report in A3");
        //StandaloneTest.login();
        //StandaloneTest.logout();
    }
}
