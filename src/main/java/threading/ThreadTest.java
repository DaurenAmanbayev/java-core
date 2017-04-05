package threading;

public class ThreadTest {
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
        Thread[] threads = new Thread[numOfFiles];

        for (int i = 0; i < numOfFiles; i++) {
            Adder adder = new Adder(inputFiles[i], outputFiles[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }
}
