package helper;

import config.ConfigReader;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AppiumServerHelper {
    private static String IP_ADDRESS = ConfigReader.emulatorConfig.ipAddress();
    private static int PORT = ConfigReader.emulatorConfig.port();
    protected static AppiumServiceBuilder service;
    protected static AppiumDriverLocalService localService;

    public static AppiumServiceBuilder startAppiumServiceBuilder(){
        service =
                new AppiumServiceBuilder()
                        .withIPAddress(IP_ADDRESS).usingPort(PORT);
        return service;
    }

//    public static AppiumDriverLocalService startAppiumServer(){
//        IP_ADDRESS = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : IP_ADDRESS;
//        PORT = System.getProperty("port") != null ? Integer.parseInt(System.getProperty("port")) : PORT;
////        initialAppiumServiceBuilder();
//        return localService;
//    }
//
//
//
//    private static void initialAppiumServiceBuilder() {
//        AppiumServiceBuilder service =
//                new AppiumServiceBuilder()
//                        .withAppiumJS(new File("C:/Users/Stanislav/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
//                        .withIPAddress(IP_ADDRESS).usingPort(PORT);
//        localService = AppiumDriverLocalService.buildService(service);
//        localService.start();
//    }
//

//    public static void shutDownServer(){
//        localService.stop();
//    }

    public static void shutDownServer(){
        service.build().stop();
    }
}
