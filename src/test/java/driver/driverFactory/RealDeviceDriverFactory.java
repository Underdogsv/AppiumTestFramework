package driver.driverFactory;

import config.ConfigReader;
import helper.AppiumServerHelper;
import helper.CapabilityHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RealDeviceDriverFactory implements AppiumDriverFactory {

    @SneakyThrows
    public AppiumDriver createDriver(){
        String platformName = ConfigReader.emulatorConfig.platformName();
        String deviceType = ConfigReader.emulatorConfig.deviceType();
        AppiumServiceBuilder remoteServer = new AppiumServerHelper().startAppiumServiceBuilder();
        DesiredCapabilities options = new CapabilityHelper().getDesiredCapabilitiesOptions();
        if (platformName.equalsIgnoreCase("android")){
              return new AndroidDriver(remoteServer, options);
        }else if (platformName.equalsIgnoreCase("iOs")){
            //    returns IOs driver if it will be implemented
        }  throw new IllegalArgumentException("Unsupported device type: " + deviceType);
    }
}