package helpers;

import config.ConfigReader;
import driver.AppiumTestInit;

public class RunHelper {

    /* This class can be extended for adding additional parameters*/
    public Class<?> getDriverClass() {
        String deviceHost = ConfigReader.testConfig.deviceHost();
        switch (deviceHost) {
            case "browserstack":
                //    return BrowserstackMobileDriver.class;
            case "selenoid":
                //   return SelenoidMobileDriver.class;
            case "emulator":
                return AppiumTestInit.class;
            case "real":
                //    return RealMobileDriver.class;
            default:
                throw new RuntimeException("DeviceHost  value is absent in testConfig File");
        }
    }
}
