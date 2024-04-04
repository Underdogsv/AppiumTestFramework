package driver.driverFactory;

import config.ConfigReader;
import helper.CapabilityHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class RemoteDriverFactory  implements AppiumDriverFactory {

    @SneakyThrows
    public AppiumDriver createDriver(){
        String platformName = ConfigReader.emulatorConfig.platformName();
        String remoteURL = ConfigReader.emulatorConfig.remoteURL();
        DesiredCapabilities options = new CapabilityHelper().getDesiredCapabilitiesOptions();
        if (platformName.equalsIgnoreCase("android")){
            return new AndroidDriver(new URL(remoteURL), options);
        }else if (platformName.equalsIgnoreCase("iOs")){
            //    returns IOs driver if it will be implemented
        }
        throw new IllegalArgumentException("Unsupported platform type: " + platformName);
    }
}
