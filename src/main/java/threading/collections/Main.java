package threading.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * This package does not make much sense. Just trying out some synchronized stuff
 */

public class Main {
    private static final int THREAD_POOL_SIZE = 1000;
    private static final String BALANCE = "balance";

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        long startTime = System.nanoTime();

        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<String, String>() {{
            put(BALANCE, "150");
        }});

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>() {{
            put(BALANCE, "150");
        }};


        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            Worker worker = new Worker(concurrentHashMap);
            es.submit(worker);
        }

        es.shutdown();
        es.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        long endTime = System.nanoTime();

        System.out.println("Total time taken : " + (endTime - startTime) / 10000);
    }

}
