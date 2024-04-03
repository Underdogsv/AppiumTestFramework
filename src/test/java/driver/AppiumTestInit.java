package driver;

import com.google.common.collect.ImmutableMap;
import config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.io.File;
import java.time.Duration;

public class AppiumTestInit {
    private static String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();
    private static String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    private static String IP_ADDRESS = ConfigReader.emulatorConfig.ipAddress();
    private static int PORT = ConfigReader.emulatorConfig.port();
    private static final String APP = ConfigReader.emulatorConfig.app();
    private static String NODE_JS_PATH = ConfigReader.testConfig.nodeJsPath();

    protected static AndroidDriver driver;
    protected static AppiumDriverLocalService localService;
    protected static WebDriverWait wait;
    protected static LoginPage loginPage;
    protected static UiAutomator2Options options;


    public static void ConfigureAppium() {
        System.out.println("Starting Appium");

        options = new UiAutomator2Options();

        String appiumChallengeApk = System.getProperty("user.dir") + APP;

        DEVICE_NAME = System.getProperty("deviceName") != null ? System.getProperty("deviceName") : DEVICE_NAME;
        PLATFORM_NAME = System.getProperty("platformName") != null ? System.getProperty("platformName") : PLATFORM_NAME;
        IP_ADDRESS = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : IP_ADDRESS;
        PORT = System.getProperty("port") != null ? Integer.parseInt(System.getProperty("port")) : PORT;
        NODE_JS_PATH = System.getProperty("nodeJsPath") != null ? System.getProperty("nodeJsPath") : NODE_JS_PATH;

        options.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        options.setCapability("deviceName", DEVICE_NAME);
        options.setCapability("platformName", PLATFORM_NAME);
        options.setCapability("appPackage", APP_PACKAGE);
        options.setCapability("appActivity", APP_ACTIVITY);
        options.setCapability("app", appiumChallengeApk);

        options.setAppPackage("com.vodqareactnative");
        options.setAppActivity("com.vodqareactnative.MainActivity");
        startAppiumServiceBuilder(IP_ADDRESS, PORT);
        driver = new AndroidDriver(localService.getUrl(), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        passSystemScreen();
        loginPage = new LoginPage(driver);
    }

    protected void refreshApplication() {
        String appPackage = driver.getCapabilities().getCapability("appPackage").toString();
        driver.executeScript("mobile: clearApp", ImmutableMap.of("appId", appPackage));
        driver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.vodqareactnative/com.vodqareactnative.MainActivity"));
        passSystemScreen();
    }


    private static void passSystemScreen() {
        String rootLocator = "//*[@class='android.widget.Button']";
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rootLocator+ "[2]"))).isDisplayed()) {
            driver.findElement(By.xpath(rootLocator+ "[2]")).click();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rootLocator))).isDisplayed()) {
                driver.findElement(By.xpath(rootLocator)).click();
            }
        }
    }

    public static void startAppiumServiceBuilder(String ipAddress, Integer port) {
        AppiumServiceBuilder service =
                new AppiumServiceBuilder().withAppiumJS(new File(NODE_JS_PATH));
        service.withIPAddress(ipAddress).usingPort(port);
        localService = AppiumDriverLocalService.buildService(service);
        localService.start();
    }

    public static void tearDown() {
        driver.quit();
        localService.stop();
    }
}
