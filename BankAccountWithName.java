public class BankAccountWithName {
    private double balance;
    private String name;

    public BankAccountWithName(){
        balance = 0;
        name = "Jane Doe";
    }

    public BankAccountWithName(double initialBalance, String n){
        balance = initialBalance;
        name = n;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }

    public void withdraw(double amount){
        balance = balance - amount;
    }

    public double getBalance(){
        return balance;
    }

    public String getName(){
        return name;
    }
}
