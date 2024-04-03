package pages.WebScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AndroidActions;

import java.time.Duration;

public class NewsPage extends AndroidActions {
    AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='login']")
    private WebElement loginButtonElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='logout']")
    private WebElement logOutElement;

    public NewsPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public boolean isMyProfileDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(logOutElement));
        return logOutElement.isDisplayed();
    }

    public void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButtonElement));
        loginButtonElement.click();
    }

    public void clickLogoutButton(){
        logOutElement.click();
    }
}
