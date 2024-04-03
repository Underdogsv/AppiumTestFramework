package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.time.Duration;

public class DragAndDropPage extends AndroidActions {
    AppiumDriver driver;

    @AndroidFindBy(accessibility = "dropzone")
    private WebElement dropzoneElement;

    @AndroidFindBy(accessibility = "dragMe")
    private WebElement dragMeElement;

    @AndroidFindBy(accessibility = "success")
    private WebElement resultMessageElement;

    public DragAndDropPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public String getResultMessage() {
        return resultMessageElement.getText();
    }

    public void dragElementAndDropInZone() {
        dragAndDropElement(dragMeElement, dropzoneElement);
    }
}
