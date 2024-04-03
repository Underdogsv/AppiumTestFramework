package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.time.Duration;
import java.util.Collections;

import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;

public class LongPressPage extends AndroidActions {
    AndroidDriver driver;

    @AndroidFindBy(accessibility = "longpress")
    private WebElement longPressButton;

    public LongPressPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void performLongPressOnButton(){
        longClick(longPressButton);
    }
    public void performLongPressOnButton1(){
        PointerInput finger = new PointerInput(TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
//        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), sourceP.x, sourceP.y));
//        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(new Pause(finger, Duration.ofMillis(2000)));
//        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), targetP.x, targetP.y));
//        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(dragNDrop));
    }


    public String getPopUpMessage(){
        return driver.findElement(AppiumBy.id("android:id/message")).getText();
    }

}
