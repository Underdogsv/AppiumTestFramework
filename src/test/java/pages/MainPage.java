package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AndroidActions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MainPage extends AndroidActions {
    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    private List<WebElement> menuItemsList;

    public MainPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public boolean isItemInViewPort(String text) {
        return !driver.findElements(By.xpath(String.format("//android.widget.TextView[@text='%s']", text))).isEmpty();
    }

    public Boolean isMenuTitleDisplayed() {
        return getMainMenuItemByText("Samples List") != null;
    }

    private WebElement getMainMenuItemByText(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//android.widget.TextView[@text='%s']", text))));
            return driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", text)));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void selectMainMenuItemByText(String text) {
        try {
            getMainMenuItemByText(text).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
