package streams.zip;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aksuryawanshi on 3/31/17.
 * This class will create a zip file, open it, copy the contents of another file in it
 */
public class Main {
    public static void main(String[] args) {
        String zipPath = "/Users/aksuryawanshi/Desktop/practice/java-core/src/main/resources/file3.zip";
        try (FileSystem zipFs = createZip(Paths.get(zipPath))) {
            copyIntoZipFs(zipFs);
            writeToZipFs(zipFs);
            writetoZipFs2(zipFs);
        } catch (Exception e) {
            System.out.println("Error : " + e.getClass().getSimpleName() + " message : " + e.getMessage());
        }
    }

    public static FileSystem createZip(Path filePath) throws URISyntaxException, IOException {
        Map<String, String> properties = new HashMap<>();
        properties.put("create", "true");
        URI uri = new URI("jar:file", filePath.toUri().getPath(), null);
        FileSystem zipFs = FileSystems.newFileSystem(uri, properties);
        return zipFs;
    }

    public static void copyIntoZipFs(FileSystem zipFs) throws IOException {
        Path inputPath = Paths.get("/Users/aksuryawanshi/Desktop/practice/java-core/src/main/resources/file.txt");
        Path outputPath = zipFs.getPath("/fileCopy.txt");
        Files.copy(inputPath, outputPath, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void writeToZipFs(FileSystem zipFs) throws IOException {
        String[] text = {"This is some text",
                "This is some other text",
                "And some more crap"};
        try (BufferedWriter br = Files.newBufferedWriter(zipFs.getPath("/newFile.txt"))) {
            for (int i = 0; i < text.length; i++) {
                br.write(text[i]);
                br.newLine();
            }
        }
    }

    public static void writetoZipFs2(FileSystem zipFs) throws IOException {
        String[] text = {"This is some text",
                "This is some other text",
                "And some more crap"};

        Files.write(zipFs.getPath("newFile2.txt"), Arrays.asList(text), Charset.defaultCharset(), StandardOpenOption.CREATE);
    }
}
