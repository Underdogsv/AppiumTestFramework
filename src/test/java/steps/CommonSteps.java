package steps;

import driver.TestInit;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


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
    public static void performAfterSuit() {
        tearDown();
    }
}
