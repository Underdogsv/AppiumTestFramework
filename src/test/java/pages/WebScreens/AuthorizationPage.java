package pages.WebScreens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AndroidActions;

import java.time.Duration;

public class AuthorizationPage extends AndroidActions {
    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='create account']")
    private WebElement createAccountButton;

    public AuthorizationPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void clickCreateAccountButton(){
        wait.until(ExpectedConditions.visibilityOf(createAccountButton));
        createAccountButton.click();
    }
}
