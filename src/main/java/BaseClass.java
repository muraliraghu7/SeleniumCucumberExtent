import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;
    public static HashMap<String, String> mymap;



   // @BeforeTest()
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\browserDrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setBrowserName("chrome");
        options.merge(capabilities);
        Log.info("Launching browser");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @BeforeSuite(alwaysRun = true)
    public void readPropertyFile() throws FileNotFoundException {
        DOMConfigurator.configure("log4j.xml");

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\parameters.properties");
            prop.load(ip);
            mymap= new HashMap<String, String>((Map) prop);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //@AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
    @AfterTest
    public void testEnds()
    {Log.info("*********************** Test Ends here ************************");}
}