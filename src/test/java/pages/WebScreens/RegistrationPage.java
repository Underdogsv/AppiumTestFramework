package pages.WebScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AndroidActions;

import java.time.Duration;

public class RegistrationPage extends AndroidActions {
    AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='create account']")
    private WebElement createAccountButton;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private WebElement passwordField;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement captchaCheckbox;

    public RegistrationPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void resolveCaptcha() {
        captchaCheckbox.click();
        wait.until(ExpectedConditions.attributeContains(captchaCheckbox, "checked", "true"));
    }

    public void setUsername(String value) {
        usernameField.sendKeys(value);
    }

    public void setPassword(String value) {
        passwordField.sendKeys(value);
    }

    public void clickCreateAccountButton() {
        wait.until(ExpectedConditions.visibilityOf(createAccountButton));
        createAccountButton.click();
    }
}
