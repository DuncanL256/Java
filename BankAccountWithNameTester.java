public class BankAccountWithNameTester {
    public static void main(String[] args) {
        BankAccountWithName harrysChecking = new BankAccountWithName();
        harrysChecking.deposit(2000);
        harrysChecking.withdraw(500);
        System.out.println(harrysChecking.getBalance());
        System.out.println("expected: 1500");

        BankAccountWithName sueAccount= new BankAccountWithName(300, "Sue");
        System.out.println(sueAccount.getName());
        System.out.println(sueAccount.getBalance());
    }
}

