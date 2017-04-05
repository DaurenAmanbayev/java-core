package threading;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class AdderCallable implements Callable<Integer> {
    private String inputFile;

    public AdderCallable(String inputFile) {
        this.inputFile = inputFile;
    }

    public int doAdd() throws IOException {
        int total = 0;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFile))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                total += Integer.parseInt(line);
            }
        }

        return total;
    }

    @Override
    public Integer call() throws Exception {
        return doAdd();
    }
}
