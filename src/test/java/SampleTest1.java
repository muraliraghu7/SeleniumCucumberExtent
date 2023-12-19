import org.testng.annotations.Test;

public class SampleTest1 extends BaseClass {
    @Test(timeOut = 3000,priority = 2)
    public void runLoginAndLogout() throws InterruptedException {
        Log.info("B1");
        Thread.sleep(2000);
        // StandaloneTest.login();
        //StandaloneTest.logout();
    }

    @Test(priority = 0,groups = {"smoke"})
    public void runLoginAndLogout1() {
        Log.info("B2");

        //StandaloneTest.login1();
        //StandaloneTest.logout();
    }

    @Test(priority = 1,groups = {"sanity"})
    public void runLoginAndLogout3() {
        Log.info("B3");
        //StandaloneTest.login();
        //StandaloneTest.logout();
    }
}
