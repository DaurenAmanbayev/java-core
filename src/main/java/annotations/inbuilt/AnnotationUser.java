package annotations.inbuilt;

public class AnnotationUser {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(1);
        bankAccount.setBalance(100);

        System.out.println(bankAccount);

        Way way = new Way();
        way.doItThisWay();
        way.doItThisNewWay();
    }
}
