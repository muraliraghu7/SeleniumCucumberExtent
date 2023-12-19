import Utilities.ExcelDataReader;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static ExtentReports.ExtentTestManager.startTest;

public class SampleTest extends BaseClass {
    @DataProvider(name ="excel-data")
    public Object[][] excelDP() throws IOException {
        //We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        Object[][] arrObj = ExcelDataReader.getExcelData("src\\main\\resources\\Data\\TestData.xlsx","Sheet1");
        return arrObj;
    }

    @Test(priority = 2,groups = {"smoke"},dataProvider = "excel-data")
    public void runLoginAndLogout(Method method,String keyWord1, String keyWord2) {
        startTest(method.getName(), "Test A1.");
        Log.info("A1");

        StandaloneTest.login2(keyWord1,keyWord2);
        StandaloneTest.logout();
    }

    @Test(priority = 0,groups = {"sanity"})
    public void runLoginAndLogout1(Method method) {
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");
        Log.info("A2");

        StandaloneTest.login1();
        StandaloneTest.logout();
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
        StandaloneTest.login();
        StandaloneTest.logout();
    }
}
