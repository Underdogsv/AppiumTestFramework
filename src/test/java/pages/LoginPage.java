package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AndroidActions;
import java.time.Duration;

public class LoginPage extends AndroidActions {
    AppiumDriver driver;

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement logInButton;

    @AndroidFindBy(accessibility = "username")
    private WebElement usernameField;

    @AndroidFindBy(accessibility = "password")
    private WebElement passwordField;

    @AndroidFindBy(className = "android.widget.ImageView")
    private WebElement logoImg;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void setUsernameAndPasswordValue(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void setUsernameValue(String username) {
        usernameField.sendKeys(username);
    }

    public String setUsernameValue() {
        return usernameField.getText();
    }

    public void setPasswordValue(String password) {
        passwordField.sendKeys(password);
    }

    public String getPasswordValue() {
        return passwordField.getText();
    }

    public String getUsernameBackgroundValue() {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        return usernameField.getAttribute("content-desc");
    }

    public String getPasswordBackgroundValue() {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        return passwordField.getAttribute("content-desc");
    }

    public String getLoginButtonText() {
        wait.until(ExpectedConditions.visibilityOf(logInButton));
        return logInButton.findElement(AppiumBy.xpath("//android.widget.TextView")).getText();
    }

    public Boolean isLogoDisplayed() {
        return logoImg.isDisplayed();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Button")));
        logInButton.click();
    }

    public MainPage login() {
        clickLogin();
       return new MainPage(driver);
    }
}


