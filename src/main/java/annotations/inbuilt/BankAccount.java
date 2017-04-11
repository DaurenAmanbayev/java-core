package annotations.inbuilt;

import lombok.Data;

@Data
public class BankAccount {
    private int id;
    private int balance;

    @Override
    public String toString() {
        return "Bank Account - id : " + id + " balance : " + balance;
    }
}
