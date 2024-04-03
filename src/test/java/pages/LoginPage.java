package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AndroidActions;
import java.time.Duration;

public class LoginPage extends AndroidActions {
    AndroidDriver driver;

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement logInButton;

    @AndroidFindBy(accessibility = "username")
    private WebElement usernameField;

    @AndroidFindBy(accessibility = "password")
    private WebElement passwordField;

    @AndroidFindBy(className = "android.widget.ImageView")
    private WebElement logoImg;

    public LoginPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }



    @Step("Set username and password")
    public void setUsernameAndPasswordValue(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        driver.hideKeyboard();
    }

    @Step("Set username")
    public void setUsernameValue(String username) {
        usernameField.sendKeys(username);
        driver.hideKeyboard();
    }

    @Step("Get username")
    public String setUsernameValue() {
        return usernameField.getText();
    }

    @Step("Set password")
    public void setPasswordValue(String password) {
        passwordField.sendKeys(password);
        driver.hideKeyboard();
    }

    @Step("Get password")
    public String getPasswordValue() {
        return passwordField.getText();
    }

    @Step("Get username field background text")
    public String getUsernameBackgroundValue() {
        return usernameField.getAttribute("content-desc");
    }

    @Step("Get password field background text")
    public String getPasswordBackgroundValue() {
        return passwordField.getAttribute("content-desc");
    }

    @Step("Get Login button background text")
    public String getLoginButtonText() {
        return logInButton.findElement(AppiumBy.xpath("//android.widget.TextView")).getText();
    }

    @Step("Verify that logo is displayed")
    public Boolean isLogoDisplayed() {
        return logoImg.isDisplayed();
    }

    @Step("Click on Login button")
    public void clickLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Button")));

//        wait.until(ExpectedConditions.visibilityOf(logInButton));
        logInButton.click();
    }

    @Step("Navigate to the main page")
    public MainPage login() {
        clickLogin();
       return new MainPage(driver);
    }
}


