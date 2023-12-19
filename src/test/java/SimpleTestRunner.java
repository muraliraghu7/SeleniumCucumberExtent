
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "@dummy",features = {"src/test/resources/features/test.feature"}, glue = {"com.example.definitions"}
        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},monochrome = true,publish = true)

public class SimpleTestRunner extends AbstractTestNGCucumberTests {
}
