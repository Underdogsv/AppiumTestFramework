package helper;

import config.ConfigReader;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.util.Optional;

public class AppiumServerHelper {
    private static String NODE_JS_PATH = ConfigReader.testConfig.nodeJsPath();
    private static String IP_ADDRESS = ConfigReader.emulatorConfig.ipAddress();
    private static int PORT = ConfigReader.emulatorConfig.port();
    protected static AppiumDriverLocalService localService;



    public static AppiumDriverLocalService startAppiumServer(){
        IP_ADDRESS = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : IP_ADDRESS;
        PORT = System.getProperty("port") != null ? Integer.parseInt(System.getProperty("port")) : PORT;
        resolveAppiumPath();
//        NODE_JS_PATH = System.getProperty("nodeJsPath") != null ? System.getProperty("nodeJsPath") : NODE_JS_PATH;
        initialAppiumServiceBuilder();
        return localService;
    }

    public static void resolveAppiumPath() {
        String appiumPath = null;

        // Check if running in GitHub Actions
        String githubActions = System.getenv("GITHUB_ACTIONS");
        if (githubActions != null && githubActions.equalsIgnoreCase("true")) {
            // Use GitHub Actions path
            NODE_JS_PATH = "/Users/runner/work/AppiumTestFramework/AppiumTestFramework/";
            System.setProperty("nodeJsPath", NODE_JS_PATH);
        } else {
            // Use locally specified path
            String appiumHome = System.getenv("APPIUM_HOME");
            if (appiumHome != null && !appiumHome.isEmpty()) {
                NODE_JS_PATH = appiumHome + "/build/lib/main.js";
                // + "/node_modules/appium/build/lib/main.js"
            }
        }
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
