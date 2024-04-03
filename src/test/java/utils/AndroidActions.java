package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidActions {
    AndroidDriver driver;
    protected WebDriverWait wait;

    @AndroidFindBy(id = "android:id/message")
    private WebElement androidMessageElement;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement androidPopUpOkButtonElement;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPopUpMessage() {
        wait.until(ExpectedConditions.visibilityOf(androidMessageElement));
        return androidMessageElement.getText();
    }

    public void clickOkOnPopUp() {
        wait.until(ExpectedConditions.visibilityOf(androidMessageElement));
        androidPopUpOkButtonElement.click();
    }

    public void doubleClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public void longClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 2000));
    }

    public void scrollPageDown() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
    }

    protected void swipeElement(WebElement element,String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public void dragAndDropElement(WebElement movedElement, WebElement dropzoneElement) {
        int startX = dropzoneElement.getLocation().getX() + dropzoneElement.getSize().getWidth() / 2;
        int startY = dropzoneElement.getLocation().getY() + dropzoneElement.getSize().getHeight() / 2;
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) movedElement).getId(),
                "endX", startX,
                "endY", startY
        ));
    }
}
