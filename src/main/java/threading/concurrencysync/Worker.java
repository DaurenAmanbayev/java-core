package threading.concurrencysync;


public class Worker implements Runnable {
    private BankAccount bankAccount;

    public Worker(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Start balance : " + bankAccount.getBalance() + "Worker : " + Thread.currentThread());
            bankAccount.deposit(100);
            System.out.println("End Balance : " + bankAccount.getBalance());
        }
    }
}
