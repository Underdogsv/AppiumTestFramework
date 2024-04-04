package driver.driverFactory;

import config.ConfigReader;
import helper.AppiumServerHelper;
import helper.CapabilityHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EmulatorDriverFactory  implements AppiumDriverFactory {

    @SneakyThrows
      public AppiumDriver createDriver(){
          String platformName = ConfigReader.emulatorConfig.platformName();
          DesiredCapabilities options = new CapabilityHelper().getDesiredCapabilitiesOptions();
          AppiumServiceBuilder remoteServer = new AppiumServerHelper().startAppiumServiceBuilder();
          if (platformName.equalsIgnoreCase("android")){
              return new AndroidDriver(remoteServer, options);
          }else if (platformName.equalsIgnoreCase("iOs")){
          }
          throw new IllegalArgumentException("Unsupported platform type: " + platformName);
      }
}

