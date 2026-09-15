public class BankAccountInterestTester {
    public static void main(String[] args) {
        BankAccountInterest harrysChecking = new BankAccountInterest();
        harrysChecking.deposit(2000);
        System.out.println("Harrys initial ballance is: " + harrysChecking.getBalance());

        BankAccountInterest joesChecking = new BankAccountInterest();
        joesChecking.deposit(5200);
        System.out.println("Joes initial ballance is: " + joesChecking.getBalance());

        BankAccountInterest liamsChecking = new BankAccountInterest();
        liamsChecking.deposit(800);
        System.out.println("Liams initial ballance is: " + liamsChecking.getBalance());
        
        // its a spacer for better organization
        System.out.println(" ");

        harrysChecking.addInterest(2);
        System.out.println("Harrys balance with interest is: " + harrysChecking.returnInterest());

        joesChecking.addInterest(4);
        System.out.println("Joes balance with interest is: " + joesChecking.returnInterest());

        liamsChecking.addInterest(1.8);
        System.out.println("Liams balance with interest is: " + liamsChecking.returnInterest());
    }
}
