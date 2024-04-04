package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:src/resources/configs/test.properties",
})
public interface ITestConfig extends Config {
      @Key("deviceHost")
    String deviceHost();
}
