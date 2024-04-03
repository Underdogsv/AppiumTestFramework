package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.time.Duration;

public class DoubleTapPage extends AndroidActions {

    AndroidDriver driver;

    @AndroidFindBy(accessibility = "doubleTapMe")
    private WebElement doubleTapButton;

    public DoubleTapPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void performDoubleTapByButton(){
        doubleClick(doubleTapButton);
    }

}
