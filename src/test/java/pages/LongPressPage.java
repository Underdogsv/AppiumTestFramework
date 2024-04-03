package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.time.Duration;

public class LongPressPage extends AndroidActions {
    AppiumDriver driver;

    @AndroidFindBy(accessibility = "longpress")
    private WebElement longPressButton;

    public LongPressPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void performLongPressOnButton(){
        longClick(longPressButton);
    }

    public String getPopUpMessage(){
        return driver.findElement(AppiumBy.id("android:id/message")).getText();
    }
}
