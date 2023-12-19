package com.example.definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class sampleDef  {
    public static WebDriver driver;
    @Before
    public void testBefore()
    {
        System.out.println("Before test");
    }
    @After
    public void Aftertest()
    {
        System.out.println("After test")
        ;
        driver.quit();
    }
    @Before
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\browserDrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setBrowserName("chrome");
        options.merge(capabilities);
        Reporter.log("Launching browser");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "screenshot");
        }

    }

    @Given("Login to the application")
    public void login_to_the_application() {
        System.out.println("abcd");
        driver.get("https://rahulshettyacademy.com/client/");
        Reporter.log("Opening the url");
        driver.findElement(By.id("userEmail")).sendKeys("murali@abc.com");
        driver.findElement(By.id("userPassword")).sendKeys("Abcd@123");
        driver.findElement(By.id("login")).click();
        Assert.assertTrue(false);


    }
    @Then("Logout of the application")
    public void logout_of_the_application() {
        System.out.println("efgh");
        Reporter.log("Going to Logout");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[contains(text(),'Sign Out')]")).click();

    }


}
