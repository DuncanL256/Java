public class EnhancedBankAccount {
    private double balance;

    public EnhancedBankAccount(){
        balance = 0;
    }

    public EnhancedBankAccount(double initialBalance){
        balance = initialBalance;
    }

    public void deposit(double amount){
        if (amount < 0){
            System.out.println("You cannot make a negative deposit");
        } else{
            balance = balance + amount;
        }
        
    }

    public void withdraw(double amount){
        if (amount < 0){
            System.out.println("You do not have enough money to make a withdrawl");
        } else{
            balance = balance - amount;
        }
        
    }

    public double getBalance(){
        return balance;
    }


}
