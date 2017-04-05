package threading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Adder implements Runnable {
    private String inputFile;
    private String outputFile;

    public Adder(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public void doAdd() throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFile));
             BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputFile))) {
            Integer total = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                int val = Integer.parseInt(line);
                total += val;
            }
            bw.write(total.toString());
        }
    }

    @Override
    public void run() {
        try {
            doAdd();
        } catch (IOException e) {
            System.out.println("Error occured while writing total for file : " + inputFile);
            System.out.println("Exception : " + e.getClass().getName() + " Message : " + e.getMessage());
        }
    }
}
