package steps;

import driver.TestInit;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CommonSteps extends TestInit{
    private static final Logger logger = LogManager.getLogger(CommonSteps.class);

    @Given("^Start application$")
    public void startApplication() {
        TestInit.GoTest();
        logger.info("Appium driver and Remote server is moved on");
    }

    @Given("^Go back")
    public static void goBack() {
        driver.navigate().back();
    }

    @And("Click login button")
    public void enterCredentialsAndLogin() {
        loginPage.clickLogin();
    }

     @After
    public static void performAfterSuit(Scenario scenario) {
         //validate if scenario has failed
         if(scenario.isFailed()) {
             final byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
             scenario.attach(screenshot, "image/png", scenario.getName());
         }
         tearDown();
    }
}
