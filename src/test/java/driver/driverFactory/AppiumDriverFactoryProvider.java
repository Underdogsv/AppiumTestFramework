package driver.driverFactory;

import config.ConfigReader;

public class AppiumDriverFactoryProvider {
    public static AppiumDriverFactory getFactory() {
        String deviceType = ConfigReader.emulatorConfig.deviceType();
        if (deviceType.equalsIgnoreCase("real")) {
            return new RealDeviceDriverFactory();
        } else if (deviceType.equalsIgnoreCase("emulator")) {
            return new EmulatorDriverFactory();
        }
        throw new IllegalArgumentException("Unsupported device type: " + deviceType);
    }
}