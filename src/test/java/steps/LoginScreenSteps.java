package steps;

import driver.TestInit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;

import static common.Constants.ENTER_USERNAME_OR_PASSWORD_MESSAGE;
import static common.Constants.INVALID_CREDENTIALS;

public class LoginScreenSteps extends TestInit {
    private static final Logger logger = LogManager.getLogger(LoginScreenSteps.class);

    @And("^Enter \"([^\"]*)\" to username and \"([^\"]*)\" to password fields on the login screen$")
    public void setUserNameAndPassword(String username, String password) {
        loginPage.setUsernameValue(username);
        loginPage.setPasswordValue(password);
    }

    @Then("^Verify that the (VodQa Logo) is displayed on Login page$")
    public void verifyThatLogoIsDisplayedOnLoginPage() {
        Assertions.assertThat(loginPage.isLogoDisplayed()).isTrue();
    }

    @Then("^Verify that the (username|password|LOG IN) field contains correct label on Login page$")
    public void verifyThatFieldContainsCorrectLabelOnLoginPage(String inputField) {
        String actual;
        if ("username".equals(inputField)) {
            actual = loginPage.getUsernameBackgroundValue();
        } else if ("password".equals(inputField)) {
            actual = loginPage.getPasswordBackgroundValue();
        } else if ("LOG IN".equals(inputField)) {
            actual = loginPage.getLoginButtonText();
        } else {
            throw new UnsupportedOperationException();
        }
        Assertions.assertThat(actual).isEqualTo(inputField);
    }

    @Then("^Verify that the (Please enter Username or password|Invalid Credentials) message is displayed on Login page$")
    public void verifyPopUpMessage(String popUpMessage) {
        String actual, expected;
        actual = loginPage.getPopUpMessage();
        if ("Please enter Username or password".equals(popUpMessage)) {
            expected = ENTER_USERNAME_OR_PASSWORD_MESSAGE;
        } else if ("Invalid Credentials".equals(popUpMessage)) {
            expected = INVALID_CREDENTIALS;
        } else {
            throw new UnsupportedOperationException();
        }
        Assertions.assertThat(actual).isEqualTo(expected);
        loginPage.clickOkOnPopUp();
    }
}
