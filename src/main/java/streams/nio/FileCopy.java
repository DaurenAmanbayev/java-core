package streams.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by aksuryawanshi on 3/31/17.
 */
public class FileCopy {
    public static void main(String[] args) {
        String inputFile = "/Users/aksuryawanshi/Desktop/practice/java-core/src/main/resources/file.txt";
        String outputFile = "/Users/aksuryawanshi/Desktop/practice/java-core/src/main/resources/file2.txt";


        // Copy all lines from input to output at once

//        try {
//            List<String> lines = Files.readAllLines(Paths.get(inputFile));
//            Files.write(Paths.get(outputFile), lines);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Copy using BufferedReader one line at a time

        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFile));
             BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {

        }
    }
}
