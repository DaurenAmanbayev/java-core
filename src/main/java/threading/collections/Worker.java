package threading.collections;

import lombok.Data;

import java.util.Map;

@Data
public class Worker implements Runnable {
    private BankAccount bankAccount;
    private final static String BALANCE = "balance";

    public Worker(Map<String, String> details) {
        bankAccount = new BankAccount(1, "akashs-saving", details);
    }

    @Override
    public void run() {
        System.out.println("Beginnning amount : " + bankAccount.getBalance() + " Thread : " + Thread.currentThread().getId());
        bankAccount.deposit(100);
        System.out.println("Amount after deposit : " + bankAccount.getBalance() + " Thread : " + Thread.currentThread().getId());
    }
}
