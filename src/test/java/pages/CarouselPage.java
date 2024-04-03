package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.time.Duration;

public class CarouselPage extends AndroidActions {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement squareElement;

    public CarouselPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public String getSquareNumber() {
        return squareElement.findElement(AppiumBy.xpath("//android.widget.TextView")).getText();
    }

    public void swipeElement(String direction) {
        swipeElement(squareElement,direction);
    }
}
