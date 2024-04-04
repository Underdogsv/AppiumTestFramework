package driver.driverFactory;

import config.ConfigReader;
import helper.AppiumServerHelper;
import helper.CapabilityHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class EmulatorDriverFactory  implements AppiumDriverFactory {
      public AppiumDriver createDriver(){
          String platformName = ConfigReader.emulatorConfig.platformName();
          AppiumDriverLocalService localServer = new AppiumServerHelper().startAppiumServer();
          AppiumServiceBuilder remoteServer = new AppiumServerHelper().startAppiumServiceBuilder();
          if (platformName.equalsIgnoreCase("android")){
              UiAutomator2Options options = new CapabilityHelper().configureCapabilityOptions();
              return new AndroidDriver(remoteServer, options);
          }else if (platformName.equalsIgnoreCase("iOs")){
              //    returns IOs driver if it will be implemented
          } else{
              //TODO remove
              UiAutomator2Options options = new CapabilityHelper().configureCapabilityOptions();
              return new AndroidDriver( options);
          }
          throw new IllegalArgumentException("Unsupported platform type: " + platformName);
      }
}

