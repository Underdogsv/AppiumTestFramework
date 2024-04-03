package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommonUtils {

    public static Faker getFakeTestData (){
        Faker faker = new Faker();

        String username = faker.name().lastName();
        String password = faker.lorem().word();
        String city = faker.address().city();
        return faker;
    }


    public static <T>List<T> getJsonAsObjectUsingGson(String jsonFilePath, Class<T[]> cl) throws Exception {
        Gson gson = new Gson();
        String jsonSting = new String(Files.readAllBytes(Paths.get((System.getProperty("user.dir") + jsonFilePath))));
        return Arrays.asList(new Gson().fromJson(jsonSting,cl));

    }

    public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir") + jsonFilePath));
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;
    }
}
