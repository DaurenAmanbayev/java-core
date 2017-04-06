package threading.concurrency;

import lombok.Data;

@Data
public class BankAccount {
    private int balance;

    public BankAccount(int startBalance) {
        this.balance = startBalance;
    }

    public void deposit(int amount) {
        balance += amount;
    }


}
