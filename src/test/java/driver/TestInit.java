package driver;

import com.google.common.collect.ImmutableMap;
//import io.appium.java_client.AppiumDriver;
import helper.AppiumServerHelper;
import driver.driverFactory.AppiumDriverFactory;
import driver.driverFactory.AppiumDriverFactoryProvider;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;

public class TestInit {
    protected static AppiumDriver driver;
    protected static WebDriverWait wait;
    protected static LoginPage loginPage;

    public static void GoTest() {
        System.out.println("Starting Appium");


        AppiumDriverFactory factory = AppiumDriverFactoryProvider.getFactory();
        driver = factory.createDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        passSystemScreen();
        loginPage = new LoginPage(driver);
    }

    private static boolean isRealDeviceConnected() {
        try {
            Process process = Runtime.getRuntime().exec("adb devices");
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("emulator-")) {
                    return false;
                }
            }
            return true;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }


    protected void refreshApplication() {
        String appPackage = driver.getCapabilities().getCapability("appPackage").toString();
        driver.executeScript("mobile: clearApp", ImmutableMap.of("appId", appPackage));
        driver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.vodqareactnative/com.vodqareactnative.MainActivity"));
        passSystemScreen();
    }


    private static void passSystemScreen() {
        String rootLocator = "//*[@class='android.widget.Button']";
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rootLocator + "[2]"))).isDisplayed()) {
            driver.findElement(By.xpath(rootLocator + "[2]")).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rootLocator))).isDisplayed()) {
                driver.findElement(By.xpath(rootLocator)).click();
            }
        }
    }

    public static void tearDown() {
        driver.quit();
//        AppiumServerHelper.shutDownServer();
    }
}