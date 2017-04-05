package threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {
    public static void main(String[] args) throws InterruptedException {
        String[] inputFiles = {"/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/input1.txt",
                "/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/input2.txt",
                "/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/input3.txt",
                "/Users/asuryawanshi/Desktop/practice-workspace/java-core/src/main/resources/threads/input4.txt"};
        int numOfFiles = inputFiles.length;
        Future<Integer>[] results = new Future[numOfFiles];
        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 0; i < numOfFiles; i++) {
            AdderCallable adder = new AdderCallable(inputFiles[i]);
            results[i] = es.submit(adder);
        }

        for (Future result : results) {
            try {
                int value = (int) result.get();
                System.out.println("Result from thread is " + value);
            } catch (ExecutionException e) {
                Throwable ex = e.getCause();
                System.out.printf("Exception : " + ex.getClass().getName() + "occured in child process" + " message : " + ex.getMessage());
            }
        }

    }
}
