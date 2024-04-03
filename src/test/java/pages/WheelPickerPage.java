package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.time.Duration;

public class WheelPickerPage extends AndroidActions {
    AppiumDriver driver;

    @AndroidFindBy(className = "android.widget.Spinner")
    private WebElement dropDownElement;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]//android.view.ViewGroup//android.widget.TextView")
    private WebElement headerLineElement;

    public WheelPickerPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void selectDropDownItemByColor(String color) {
        dropDownElement.click();
        driver.findElements(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1']"))
                .stream().filter(s -> s.getText().equals(color)).findFirst().get().click();
    }

    public String getHeaderColor() {
        return headerLineElement.getText();
    }
}
