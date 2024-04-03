package driver.driverFactory;

import io.appium.java_client.AppiumDriver;

public interface AppiumDriverFactory {
    AppiumDriver  createDriver();
}
