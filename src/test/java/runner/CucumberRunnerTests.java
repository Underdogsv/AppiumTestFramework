package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "not @disabled", features = {"src/test/resources/features"}, glue = {"steps"},
        plugin = {})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}