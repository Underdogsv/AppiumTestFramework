package helper;

import config.ConfigReader;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumServerHelper {
    private static String NODE_JS_PATH = ConfigReader.testConfig.nodeJsPath();
    private static String IP_ADDRESS = ConfigReader.emulatorConfig.ipAddress();
    private static int PORT = ConfigReader.emulatorConfig.port();
    protected static AppiumDriverLocalService localService;



    public static AppiumDriverLocalService startAppiumServer(){
        IP_ADDRESS = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : IP_ADDRESS;
        PORT = System.getProperty("port") != null ? Integer.parseInt(System.getProperty("port")) : PORT;
        NODE_JS_PATH = System.getProperty("nodeJsPath") != null ? System.getProperty("nodeJsPath") : NODE_JS_PATH;
        initialAppiumServiceBuilder();
        return localService;
    }



    private static void initialAppiumServiceBuilder() {
        AppiumServiceBuilder service =
                new AppiumServiceBuilder().withAppiumJS(new File(NODE_JS_PATH));
        service.withIPAddress(IP_ADDRESS).usingPort(PORT);
        localService = AppiumDriverLocalService.buildService(service);
        localService.start();
    }

    public static void shutDownServer(){
        localService.stop();
    }
}
