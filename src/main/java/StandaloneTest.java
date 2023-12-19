import org.openqa.selenium.By;

public class StandaloneTest extends BaseClass {

    public static void login() {
        Log.startTestCase("login test");

        driver.get("https://rahulshettyacademy.com/client/");
        Log.info("Opening the url");
        driver.findElement(By.id("userEmail")).sendKeys(mymap.get("username"));
        driver.findElement(By.id("userPassword")).sendKeys(mymap.get("password"));
        driver.findElement(By.id("login")).click();

    }
    public static void login1() {
        Log.startTestCase("login test");

        driver.get("https://rahulshettyacademy.com/client/");
        Log.info("Opening the url");
        driver.findElement(By.id("userEmail")).sendKeys(mymap.get("username"));
        driver.findElement(By.id("userPassword")).sendKeys(mymap.get("password"));
        driver.findElement(By.id("login")).click();

    }
    public static void logout()
    {
        Log.info("Going to Logout");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[contains(text(),'Sign Out')]")).click();
        Log.endTestCase();
    }
}
