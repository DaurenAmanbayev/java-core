package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        String[] inputFiles = {"/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/input1.txt",
                "/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/input2.txt",
                "/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/input3.txt",
                "/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/input4.txt"};
        String[] outputFiles = {"/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/output1.txt",
                "/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/output2.txt",
                "/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/output3.txt",
                "/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/output4.txt"};
        int numOfFiles = inputFiles.length;
        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 0; i < numOfFiles; i++) {
            Adder adder = new Adder(inputFiles[i], outputFiles[i]);
            es.submit(adder);
        }

        es.shutdown();
        es.awaitTermination(60, TimeUnit.SECONDS);
    }
}
