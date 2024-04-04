package helper;

import config.ConfigReader;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityHelper {

    private static String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();
    private static String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    private static final String APP = ConfigReader.emulatorConfig.app();
    public static UiAutomator2Options options = new UiAutomator2Options();


    public DesiredCapabilities getDesiredCapabilitiesOptions() {
        DesiredCapabilities options = new DesiredCapabilities();
        String appiumChallengeApk = System.getProperty("user.dir") + APP;

        DEVICE_NAME = System.getProperty("deviceName") != null ? System.getProperty("deviceName") : DEVICE_NAME;
        PLATFORM_NAME = System.getProperty("platformName") != null ? System.getProperty("platformName") : PLATFORM_NAME;
        APP_PACKAGE = System.getProperty("appPackage") != null ? System.getProperty("appPackage") : APP_PACKAGE;
        APP_ACTIVITY = System.getProperty("appActivity") != null ? System.getProperty("appActivity") : APP_ACTIVITY;

        options.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        options.setCapability("deviceName", DEVICE_NAME);
        options.setCapability("platformName", PLATFORM_NAME);
//        options.setCapability("platformName", "ANDROID");
        options.setCapability("appPackage", APP_PACKAGE);
        options.setCapability("appActivity", APP_ACTIVITY);
        options.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);

        options.setCapability("app", appiumChallengeApk);
        return options;
    }

    public UiAutomator2Options configureCapabilityOptions() {
        options = new UiAutomator2Options();
        String appiumChallengeApk = System.getProperty("user.dir") + APP;

        DEVICE_NAME = System.getProperty("deviceName") != null ? System.getProperty("deviceName") : DEVICE_NAME;
        PLATFORM_NAME = System.getProperty("platformName") != null ? System.getProperty("platformName") : PLATFORM_NAME;
        APP_PACKAGE = System.getProperty("appPackage") != null ? System.getProperty("appPackage") : APP_PACKAGE;
        APP_ACTIVITY = System.getProperty("appActivity") != null ? System.getProperty("appActivity") : APP_ACTIVITY;

        options.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        options.setCapability("deviceName", DEVICE_NAME);
        options.setCapability("appPackage", APP_PACKAGE);
        options.setCapability("appActivity", APP_ACTIVITY);
                options.setCapability("platformName", PLATFORM_NAME);
//        options.setCapability("platformName", "ANDROID");
        options.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        options.setCapability("app", appiumChallengeApk);
        return options;
    }
}
