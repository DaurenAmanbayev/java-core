package threading.collections;

import lombok.Data;

import java.util.Map;

@Data
public class BankAccount {
    private Map<String, String> details;
    private String name;
    private int id;
    private static final String BALANCE = "balance";

    public BankAccount(int id, String name, Map<String, String> details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    public synchronized int getBalance() {
        return Integer.parseInt(details.get(BALANCE));
    }

    public synchronized void deposit(int amount) {
        int currentBalance = Integer.parseInt(details.get(BALANCE));
        currentBalance += amount;
    }
}
