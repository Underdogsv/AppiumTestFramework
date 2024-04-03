package pages.WebScreens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

/* LoginCard is a part of Authorisation screen*/
public class LoginCard extends AuthorizationPage {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "(//android.view.View[3]//android.view.View[2]/android.widget.EditText)[1]")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "(//android.view.View[3]//android.view.View[2]/android.widget.EditText)[2]")
    private WebElement passwordField;


    @AndroidFindBy(xpath = "//android.widget.Button[@text='login']")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bad login.']")
    private WebElement errorMessage;


    public LoginCard(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void setUsername(String value) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(value);
    }

    public void setPassword(String value) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(value);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

}
