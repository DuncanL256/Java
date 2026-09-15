public class EnhancedBankAccountTester {
    public static void main(String[] args) {
        EnhancedBankAccount harrysChecking = new EnhancedBankAccount();
        harrysChecking.deposit(-2000);
        harrysChecking.withdraw(50000);
        System.out.println(harrysChecking.getBalance());
        System.out.println("expected: 1500");
    }
}
