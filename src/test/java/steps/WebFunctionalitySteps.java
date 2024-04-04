package steps;

import driver.TestInit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import objects.CredentialObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import pages.WebScreens.*;

import static common.Constants.BAD_LOGIN;

public class WebFunctionalitySteps extends TestInit {
    private static final Logger logger = LogManager.getLogger(WebFunctionalitySteps.class);
    LoginCard loginCard = new LoginCard(driver);
    RegistrationCard registrationCard = new RegistrationCard(driver);
    AuthorizationPage authorizationPage = new AuthorizationPage(driver);
    NewsPage newsPage = new NewsPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    CredentialObject credentialObject = new CredentialObject().getFakeCredentialTestData();

    @Then("^Click ([^\\\"]*) button on the News page$")
    public void clickLoginButton(String button) {
        if (button.equals("login")){
            newsPage.clickLoginButton();
        }else if(button.equals("logout")){
            newsPage.clickLogoutButton();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Then("^Enter (new|existed) test data to the Login section")
    public void generateTestDataAndEnterToLoginForm(String state) {
        if (state.equals("new")) {
            credentialObject = new CredentialObject().getFakeCredentialTestData();
        }
        logger.info(String.format("Test data: username is '%s' and password is'%s'",
                credentialObject.getUsername(), credentialObject.getPassword()));

        loginCard.setUsername(credentialObject.getUsername());
        loginCard.setPassword(credentialObject.getPassword());
    }

    @And("^Click login button on Login form$")
    public void clickLoginButtonOnWebScreen() {
        loginCard.clickLoginButton();

    }

    @And("^Enter \"([^\"]*)\" to username and \"([^\"]*)\" to password fields on the Authorisation screen$")
    public void setUserNameAndPasswordAuthorisationForm(String username, String password) {
        loginCard.setUsername(username);
        loginCard.setPassword(password);
    }

    @Then("^Verify that error message is displayed$")
    public void verifyThatErrorMessageIsScreen() {
        Assertions.assertThat(loginCard.getErrorMessage()).isEqualTo(BAD_LOGIN);
    }

    @And("^Enter (new|existed) username and password to the ([^\\\"]*)$")
    public void enterUserCredentialsToAuthorisationForm(String state, String section) {

        if (state.equals("new")) {
            credentialObject = new CredentialObject().getFakeCredentialTestData();
        }

        switch (section) {
            case "Login form":
                loginCard.setUsername(credentialObject.getUsername());
                loginCard.setPassword(credentialObject.getPassword());
                break;
            case "Registration form":
                registrationCard.setUsername(credentialObject.getUsername());
                registrationCard.setPassword(credentialObject.getPassword());
                break;
            case "Registration screen":
                registrationPage.setUsername(credentialObject.getUsername());
                registrationPage.setPassword(credentialObject.getPassword());
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @And("^Click (Create Account) button on ([^\\\"]*)$")
    public void clickCreateAccountOnLoginPage(String firstParameter, String secondParameter) {
        authorizationPage.clickCreateAccountButton();
    }

    @Then("^Resolve Captcha")
    public void resolveCaptchaOnRegistrationPage() {
        registrationPage.resolveCaptcha();
    }

    @Then("^Verify that the My Profile section displayed on the News page")
    public void verifyThatUserProfileSectionDisplayed() {
       Assertions.assertThat(newsPage.isMyProfileDisplayed()).isTrue();
    }
}
