package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:src/resources/configs/emulator.properties",
})
public interface IEmulatorConfig extends Config {
    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("app")
    String app();

    @Key("browser")
    String browser();

    @Key("udid")
    int udid();

    @Key("deviceType")
    String deviceType();

    @Key("ipAddress")
    String ipAddress();

    @Key("port")
    int port();

    @Key("remoteURL")
    String remoteURL();
}