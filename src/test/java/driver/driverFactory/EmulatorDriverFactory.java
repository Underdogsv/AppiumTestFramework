package driver.driverFactory;

import config.ConfigReader;
import helper.AppiumServerHelper;
import helper.CapabilityHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


public class EmulatorDriverFactory  implements AppiumDriverFactory {

    @SneakyThrows
      public AppiumDriver createDriver(){
          String platformName = ConfigReader.emulatorConfig.platformName();
          String remoteURL = ConfigReader.emulatorConfig.remoteURL();
          DesiredCapabilities options = new CapabilityHelper().getDesiredCapabilitiesOptions();
//          AppiumServiceBuilder remoteServer = new AppiumServerHelper().startAppiumServiceBuilder();
          if (platformName.equalsIgnoreCase("android")){
              return new AndroidDriver(new URL(remoteURL), options);
//              return new AndroidDriver(remoteServer, options);
          }else if (platformName.equalsIgnoreCase("iOs")){
              //    returns IOs driver if it will be implemented
          } else{
              //TODO Extend for Remote running
              return new AndroidDriver(new URL(remoteURL), options);
//              return new AndroidDriver(remoteServer, options);
          }
          throw new IllegalArgumentException("Unsupported platform type: " + platformName);
      }
}

