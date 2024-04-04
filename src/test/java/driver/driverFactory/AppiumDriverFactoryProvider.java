package driver.driverFactory;

import config.ConfigReader;

public class AppiumDriverFactoryProvider {
    public static AppiumDriverFactory getFactory() {
        String deviceType = ConfigReader.emulatorConfig.deviceType();
        String githubActions = System.getenv("GITHUB_ACTIONS");
        if (githubActions != null && githubActions.equalsIgnoreCase("true")) {
            return new RemoteDriverFactory();
        } else if (deviceType.equalsIgnoreCase("real")) {
            return new RealDeviceDriverFactory();
        } else if (deviceType.equalsIgnoreCase("emulator")) {
            return new EmulatorDriverFactory();
        }
        throw new IllegalArgumentException("Unsupported device type: " + deviceType);
    }
}