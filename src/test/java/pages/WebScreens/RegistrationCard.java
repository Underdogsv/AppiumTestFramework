package pages.WebScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/* RegistrationCard is a part of Authorisation screen*/
public class RegistrationCard  extends AuthorizationPage {
    AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.view.View[9]//android.view.View[1]/android.view.View[2]/android.widget.EditText")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "//android.view.View[9]//android.view.View[2]/android.view.View[2]/android.widget.EditText")
    private WebElement passwordField;

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement createAccountButton;

    public RegistrationCard(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void setUsername(String value) {
        usernameField.sendKeys(value);
    }

    public void setPassword(String value) {
        passwordField.sendKeys(value);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }
}
