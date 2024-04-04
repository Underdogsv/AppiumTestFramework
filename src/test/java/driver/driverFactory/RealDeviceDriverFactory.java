package driver.driverFactory;

import config.ConfigReader;
import helper.CapabilityHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RealDeviceDriverFactory implements AppiumDriverFactory {
    public AppiumDriver createDriver(){
        String platformName = ConfigReader.emulatorConfig.platformName();
        String deviceType = ConfigReader.emulatorConfig.deviceType();
//        UiAutomator2Options options = new CapabilityHelper().configureCapabilityOptions();
        DesiredCapabilities options = new CapabilityHelper().getDesiredCapabilitiesOptions();
        if (platformName.equalsIgnoreCase("android")){
            return new AndroidDriver(options);
        }else if (platformName.equalsIgnoreCase("iOs")){
            //    returns IOs driver if it will be implemented
        }  throw new IllegalArgumentException("Unsupported device type: " + deviceType);
    }
}
