package config;
import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    /**
     * Read data from emulator.properties and  test.properties
     */
    public static final IEmulatorConfig emulatorConfig = ConfigFactory.create(IEmulatorConfig.class, System.getProperties());
    public static final ITestConfig testConfig = ConfigFactory.create(ITestConfig.class, System.getProperties());
}
