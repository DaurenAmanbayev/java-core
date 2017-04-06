package threading.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ResourceProblem {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount(150);
        ExecutorService es = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            es.submit(new Worker(bankAccount));
        }

        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);
    }
}
