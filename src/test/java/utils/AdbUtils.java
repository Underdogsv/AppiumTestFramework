package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdbUtils {
    public static String getRealDeviceUdid() {
        String udid = null;
        try {
            Process process = Runtime.getRuntime().exec("adb devices");
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.endsWith("device")) {
                    if (!line.contains("emulator")) {
                        String[] deviceInfo = line.split("\\s+");
                        udid = deviceInfo[0];
                        break;
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return udid;
    }
}
