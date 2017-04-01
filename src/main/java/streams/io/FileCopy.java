package streams.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by aksuryawanshi on 3/31/17.
 */
public class FileCopy {
    public static void main(String[] args) {
        String inputFileName = "/Users/aksuryawanshi/Desktop/practice/java-core/src/main/resources/file.txt";
        String outputFileName = "/Users/aksuryawanshi/Desktop/practice/java-core/src/main/resources/file2.txt";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getClass().getSimpleName() + " message : " + e.getMessage());
        }
    }
}
