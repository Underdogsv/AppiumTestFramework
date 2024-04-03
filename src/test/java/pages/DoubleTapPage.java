package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.time.Duration;

public class DoubleTapPage extends AndroidActions {

    AppiumDriver driver;

    @AndroidFindBy(accessibility = "doubleTapMe")
    private WebElement doubleTapButton;

    public DoubleTapPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
    public void performDoubleTapByButton(){
        doubleClick(doubleTapButton);
    }
}
