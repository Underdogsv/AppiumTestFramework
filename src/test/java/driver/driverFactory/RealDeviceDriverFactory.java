package driver.driverFactory;

import config.ConfigReader;
import helper.CapabilityHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class RealDeviceDriverFactory implements AppiumDriverFactory {
    public AppiumDriver createDriver(){
        String platformName = ConfigReader.emulatorConfig.platformName();
        String deviceType = ConfigReader.emulatorConfig.deviceType();
        if (platformName.equalsIgnoreCase("android")){
            UiAutomator2Options options = new CapabilityHelper().configureCapabilityOptions();
            return new AndroidDriver(options);
        }else if (platformName.equalsIgnoreCase("iOs")){
            //    returns IOs driver if it will be implemented
        }  throw new IllegalArgumentException("Unsupported device type: " + deviceType);
    }
}
