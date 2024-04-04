package driver.driverFactory;

import config.ConfigReader;
import helper.CapabilityHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class RealDeviceDriverFactory implements AppiumDriverFactory {

    @SneakyThrows
    public AppiumDriver createDriver(){
        String platformName = ConfigReader.emulatorConfig.platformName();
        String deviceType = ConfigReader.emulatorConfig.deviceType();
        String remoteURL = ConfigReader.emulatorConfig.remoteURL();
        DesiredCapabilities options = new CapabilityHelper().getDesiredCapabilitiesOptions();
//        UiAutomator2Options options = new CapabilityHelper().configureCapabilityOptions();
        if (platformName.equalsIgnoreCase("android")){
            return new AndroidDriver(new URL(remoteURL), options);
//              return new AndroidDriver(remoteServer, options);
        }else if (platformName.equalsIgnoreCase("iOs")){
            //    returns IOs driver if it will be implemented
        }  throw new IllegalArgumentException("Unsupported device type: " + deviceType);
    }
}
