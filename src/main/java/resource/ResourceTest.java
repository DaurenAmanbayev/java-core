package resource;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by aksuryawanshi on 4/2/17.
 */
public class ResourceTest {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.put("fname","akash");
        prop.put("lname", "suryawanshi");
        prop.put("job","developer");

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("/Users/aksuryawanshi/Desktop/practice/java-core/src/main/resources/application.properties"))){
            prop.store(bw, "This is a test resource file");
        } catch (IOException e) {
            System.out.println("Exception : " + e.getClass().getSimpleName() + " error : " + e.getMessage());
        }
    }
}
