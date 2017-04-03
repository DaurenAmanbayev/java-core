package resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by aksuryawanshi on 4/2/17.
 */
public class ResourceTest2 {
    public static void main(String[] args) {
        String firstPropertyFileName = "/Users/aksuryawanshi/Desktop/practice/java-core/src/main/resources/application-start.properties";
        Properties prop1 = new Properties();
        loadFirstProperties(firstPropertyFileName, prop1);
        Properties prop2 = new Properties(prop1);
        prop2.put("firstTime", "N");
        prop2.put("firstName", "akash");
        prop2.put("lastName", "suryawanshi");
    }

    public static void loadFirstProperties(String firstPropertyFileName, Properties prop) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(firstPropertyFileName))) {
            prop.load(br);
        } catch (Exception e) {
            System.out.println("Error while reading properties file " + firstPropertyFileName);
            System.out.println("Exception : " + e.getClass().getSimpleName() + " Error : " + e.getMessage());
        }
    }
}
