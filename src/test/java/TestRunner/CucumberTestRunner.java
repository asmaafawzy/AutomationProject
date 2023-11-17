package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", tags="@Test", // Specify the path to your feature files
        glue = "StepDefinitions" // Specify the package where your step definitions are located
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    // You don't need to add any code here unless you have additional TestNG configurations.
}