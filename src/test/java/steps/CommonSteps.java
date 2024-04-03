package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import driver.AppiumTestInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CommonSteps extends AppiumTestInit{
    private static final Logger logger = LogManager.getLogger(CommonSteps.class);

    @Given("^Start application$")
    public void startApplication() throws Throwable {
        AppiumTestInit.ConfigureAppium();
        logger.info("Appium driver and Remote server is moved on");
    }

    @Given("^Go back")
    public static void goBack() {
        driver.navigate().back();
    }

    @Given("^Close keyboard")
    public static void closeKeyBoard() {
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
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
